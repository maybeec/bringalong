import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetOrderResponse } from 'src/api';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';
import { bringOrder, getOrder, getOrderError, bringOrderSuccess, bringOrderError, getOrderSuccess } from './order.actions';

@Injectable()
export class OrderEffects {

    getOrder$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrder),
            mergeMap(
                (payload) => (this.service.getOrder(payload.id, 'body') as Observable<GetOrderResponse>)
                .pipe(
                    map(result => getOrderSuccess(result)),
                    catchError(() => of(getOrderError()))
                )
            )
        )
    );

    // bringOrder$ = createEffect(() =>
    //     this.actions$.pipe(
    //         ofType(bringOrder),
    //         mergeMap(
    //             (payload) => (this.service.bringOrder(payload.id, 'body') as Observable<BringOrderResult>) // TODO:
    //             .pipe(
    //                 map(result => {
    //                         this.store.dispatch(getOrder({id: result.id}));
    //                         return bringOrderSuccess(result);
    //                     }),
    //                 catchError(() => of(bringOrderError()))
    //             )
    //         )
    //     )
    // );

    constructor(
        private actions$: Actions,
        private service: DefaultService,
        private store: Store<AppState>
    ) {}
}
