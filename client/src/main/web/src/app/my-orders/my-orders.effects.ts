import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetStoreOrdersResult, BringOrderResult } from 'src/api';
import { getMyOrders, getMyOrdersSuccess, getMyOrdersError } from './my-orders.actions';


@Injectable()
export class MyOrdersEffects {

    getMyOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getMyOrders),
            mergeMap(
                (payload) => (this.service.getStoreOrders(1, 'body') as Observable<GetStoreOrdersResult>) // TODO:
                .pipe(
                    map(result => getMyOrdersSuccess(result)),
                    catchError(() => of(getMyOrdersError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
