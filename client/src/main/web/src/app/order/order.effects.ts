import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, LoadProductsForStoreResult } from 'src/api';
import { loadProductsForStore, loadProductsForStoreSuccess, loadProductsForStoreError } from './order.actions';


@Injectable()
export class OrderEffects {

    searchForPlz$ = createEffect(() =>
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

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
