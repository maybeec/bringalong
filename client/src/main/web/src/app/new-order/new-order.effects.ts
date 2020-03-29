import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, CreateOrderResponse } from 'src/api';
import { createOrder, createOrderSuccess, createOrderError } from './new-order.actions';
import { Router } from '@angular/router';

@Injectable()
export class NewOrderEffects {

    createOrder$ = createEffect(() =>
        this.actions$.pipe(
            ofType(createOrder),
            mergeMap(
                (payload) => (this.service.createOrder(payload, 'body') as Observable<CreateOrderResponse>)
                .pipe(
                    map(result => {
                        this.router.navigate(['/myOrders']);
                        return createOrderSuccess(result);
                    }),
                    catchError(() => of(createOrderError()))
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
