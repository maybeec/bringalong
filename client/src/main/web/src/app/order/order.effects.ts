import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, LoadProductsForStoreResult } from 'src/api';
import { loadProductsForStore, loadProductsForStoreSuccess, loadProductsForStoreError, createOrderSuccess, createOrderError, createOrder } from './order.actions';
import { CreateOrderResult } from 'src/api/model/createOrderResult';


@Injectable()
export class OrderEffects {

    loadProductsForStore$ = createEffect(() =>
        this.actions$.pipe(
            ofType(loadProductsForStore),
            mergeMap(
                (payload) => (this.service.loadProductsForStore(payload.id, 'body') as Observable<LoadProductsForStoreResult>)
                .pipe(
                    map(result => loadProductsForStoreSuccess(result)),
                    catchError(() => of(loadProductsForStoreError()))
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
