import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, LoadStoreOrdersResult } from 'src/api';
import { loadProducts, loadProductsSuccess, loadProductsError } from './order.actions';


@Injectable()
export class OrderEffects {

    searchForPlz$ = createEffect(() =>
        this.actions$.pipe(
            ofType(loadProducts),
            mergeMap(
                (payload) => (this.service.(payload.id, 'body') as Observable<LoadProductsForStoreResult>)
                .pipe(
                    map(result => loadProductsSuccess(result)),
                    catchError(() => of(loadProductsError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
