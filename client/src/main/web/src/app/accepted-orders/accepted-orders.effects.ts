import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService } from 'src/api';
import { getAcceptedOrders, getAcceptedOrdersSuccess, getAcceptedOrdersError } from './accepted-orders.actions';
import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

@Injectable()
export class AcceptedOrdersEffects {

    getAcceptedOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getAcceptedOrders),
            mergeMap(
                (payload) => (this.service
                    .findBringDemands({acceptedByUser: payload.id }, 'body') as Observable<PageBringDemandEto[]>)
                .pipe(
                    map(result => getAcceptedOrdersSuccess({ orders: result })),
                    catchError(() => of(getAcceptedOrdersError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) { }
}
