import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetProductsForStoreResult } from 'src/api';
import { getProductsForStore, getProductsForStoreSuccess, getProductsForStoreError, createOrderSuccess, createOrderError, createOrder } from './order.actions';
import { CreateOrderResult } from 'src/api/model/createOrderResult';


@Injectable()
export class OrderEffects {

    loadProductsForStore$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getProductsForStore),
            mergeMap(
                (payload) => (this.service.getProductsForStore(payload.id, 'body') as Observable<GetProductsForStoreResult>)
                .pipe(
                    map(result => getProductsForStoreSuccess(result)),
                    catchError(() => of(getProductsForStoreError()))
                )
            )
        )
    );

    createOrder$ = createEffect(() =>
        this.actions$.pipe(
            ofType(createOrder),
            mergeMap(
                (payload) => (this.service.createOrder(payload.storeId,payload.request, 'body') as Observable<CreateOrderResult>)
                .pipe(
                    map(result => createOrderSuccess(result)),
                    catchError(() => of(createOrderError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
