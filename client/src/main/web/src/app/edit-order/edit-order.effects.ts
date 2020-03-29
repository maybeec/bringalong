import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetOrdersResponse, GetOrderResponse, DeleteOrderResponse } from 'src/api';
import { getOrderForEdit, getOrderForEditSuccess, getOrderForEditError,
     deleteOrderSuccess, deleteOrderError, deleteOrder } from './edit-order.actions';
import { Router } from '@angular/router';

@Injectable()
export class EditOrderEffects {

    getOrderForEdit$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrderForEdit),
            mergeMap(
                (payload) => (this.service.getOrder(payload.id, 'body') as Observable<GetOrderResponse>)
                .pipe(
                    map(result => getOrderForEditSuccess(result)),
                    catchError(() => of(getOrderForEditError()))
                )
            )
        )
    );

    deleteOrder$ = createEffect(() =>
        this.actions$.pipe(
            ofType(deleteOrder),
            mergeMap(
                (payload) => (this.service.deleteOrder(payload.id, 'body') as Observable<DeleteOrderResponse>)
                .pipe(
                    map(result => {
                            this.router.navigate(['/myOrders']);
                            return deleteOrderSuccess(result);
                        }),
                    catchError(() => of(deleteOrderError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService,
        private router: Router
    ) {}
}
