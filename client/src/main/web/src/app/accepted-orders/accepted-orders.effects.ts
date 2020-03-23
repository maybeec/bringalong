import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetStoreOrdersResult, BringOrderResult } from 'src/api';
import { getAcceptedOrders, getAcceptedOrdersSuccess, getAcceptedOrdersError } from './accepted-orders.actions';


@Injectable()
export class AcceptedOrdersEffects {

    getAcceptedOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getAcceptedOrders),
            mergeMap(
                (payload) => (this.service.getStoreOrders(1, 'body') as Observable<GetStoreOrdersResult>) // TODO:
                .pipe(
                    map(result => getAcceptedOrdersSuccess(result)),
                    catchError(() => of(getAcceptedOrdersError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
