import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService } from 'src/api';
import { BringDemandEto } from 'src/api/model/bringDemandEto';
import { createOrder, createOrderSuccess, createOrderError } from './new-order.actions';
import { Router } from '@angular/router';

@Injectable()
export class NewOrderEffects {

    createOrder$ = createEffect(() =>
        this.actions$.pipe(
            ofType(createOrder),
            mergeMap(
                (payload) => (this.service.saveBringDemand(payload, 'body') as Observable<BringDemandEto>)
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
