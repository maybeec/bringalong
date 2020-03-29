import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetOrdersResponse } from 'src/api';
import { getAcceptedOrdersSuccess, getAcceptedOrders, getAcceptedOrdersError } from './accepted-orders.actions';

@Injectable()
export class AcceptedOrdersEffects {

    getAcceptedOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getAcceptedOrders),
            mergeMap(
                (payload) => (this.service.getOrders('accepted', 'body') as Observable<GetOrdersResponse>)
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
    ) { }
}
