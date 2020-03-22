import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetStoreOrdersResult } from 'src/api';
import { getOrders, getOrdersSuccess, getOrdersError } from './store-orders.actions';


@Injectable()
export class StoreOrdersEffects {

    loadOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrders),
            mergeMap(
                (payload) => (this.service.getStoreOrders(payload.id, 'body') as Observable<GetStoreOrdersResult>)
                .pipe(
                    map(result => getOrdersSuccess(result)),
                    catchError(() => of(getOrdersError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
