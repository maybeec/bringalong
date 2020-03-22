import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetStoreOrdersResult, BringOrderResult } from 'src/api';
import { getOrders, getOrdersSuccess, getOrdersError, bringOrder, bringOrderSuccess, bringOrderError } from './store-orders.actions';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';


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

    bringOrder$ = createEffect(() =>
        this.actions$.pipe(
            ofType(bringOrder),
            mergeMap(
                (payload) => (this.service.bringOrder(payload.id, 'body') as Observable<BringOrderResult>)
                .pipe(
                    map(result =>
                        {
                            this.store.dispatch(getOrders({id: result.storeId }));
                            return bringOrderSuccess(result);
                        }),
                    catchError(() => of(bringOrderError()))
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
