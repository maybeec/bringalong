import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetStoreOrdersResult, BringOrderResult } from 'src/api';
import { getOrders, getOrdersSuccess, getOrdersError,
     getOrdersByLatLongError, getOrdersByLatLongSuccess, getOrdersByLatLong } from './orders.actions';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';


@Injectable()
export class OrdersEffects {

    getOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrders),
            mergeMap(
                (payload) => (this.service.getStoreOrders(1, 'body') as Observable<GetStoreOrdersResult>) // TODO:
                .pipe(
                    map(result => getOrdersSuccess(result)),
                    catchError(() => of(getOrdersError()))
                )
            )
        )
    );

    getOrdersByLatLong$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrdersByLatLong),
            mergeMap(
                (payload) => (this.service.getStoreOrders(1, 'body') as Observable<GetStoreOrdersResult>) // TODO:
                .pipe(
                    map(result => getOrdersByLatLongSuccess(result)),
                    catchError(() => of(getOrdersByLatLongError()))
                )
            )
        )
    );


    constructor(
        private actions$: Actions,
        private service: DefaultService,
        private store: Store<AppState>
    ) {}
}
