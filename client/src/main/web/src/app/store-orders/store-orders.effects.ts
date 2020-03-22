import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, LoadStoreOrdersResult } from 'src/api';
import { loadOrders, loadOrdersSuccess, loadOrdersError } from './store-orders.actions';


@Injectable()
export class StoreOrdersEffects {

    searchForPlz$ = createEffect(() =>
        this.actions$.pipe(
            ofType(loadOrders),
            mergeMap(
                (payload) => (this.service.loadOrders(payload.id, 'body') as Observable<LoadStoreOrdersResult>)
                .pipe(
                    map(result => loadOrdersSuccess(result)),
                    catchError(() => of(loadOrdersError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
