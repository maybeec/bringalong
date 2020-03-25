import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService} from 'src/api';
import { getOrders, getOrdersSuccess, getOrdersError,
     getOrdersByLatLongError, getOrdersByLatLongSuccess, getOrdersByLatLong } from './orders.actions';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';
import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';


@Injectable()
export class OrdersEffects {

    getOrders$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrders),
            mergeMap(
                (payload) => (this.service.findBringDemands({  }, 'body') as Observable<PageBringDemandEto[]>) // TODO:
                .pipe(
                    map(result => getOrdersSuccess({ orders: result })),
                    catchError(() => of(getOrdersError()))
                )
            )
        )
    );

    getOrdersByLatLong$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrdersByLatLong),
            mergeMap(
                (payload) => (this.service
                    .findBringDemands({ lat: payload.lat, lon: payload.long }, 'body') as Observable<PageBringDemandEto[]>)
                .pipe(
                    map(result => getOrdersByLatLongSuccess({ orders: result })),
                    catchError(() => of(getOrdersByLatLongError()))
                )
            )
        )
    );


    constructor(
        private actions$: Actions,
        private service: DefaultService,
        private store: Store<AppState>
    ) {}
}
