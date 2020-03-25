import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService } from 'src/api';
import { getMyOrders, getMyOrdersSuccess, getMyOrdersError } from './my-orders.actions';
import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';


@Injectable()
export class MyOrdersEffects {

    getMyOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getMyOrders),
            mergeMap(
                (payload) => (this.service
                    .findBringDemands({  }, 'body') as Observable<PageBringDemandEto[]>) // TODO:
                .pipe(
                    map(result => getMyOrdersSuccess({ orders: result })),
                    catchError(() => of(getMyOrdersError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
