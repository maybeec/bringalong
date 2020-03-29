import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetOrdersByLatLongResponse} from 'src/api';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';
import { getOrdersByLatLong, getOrdersByLatLongSuccess, getOrdersByLatLongError } from './orders.actions';


@Injectable()
export class OrdersEffects {

    getOrdersByLatLong$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getOrdersByLatLong),
            mergeMap(
                (payload) => (this.service
                    .getOrdersByLatLong(payload.lat, payload.long , 'body') as Observable<GetOrdersByLatLongResponse>)
                .pipe(
                    map(result => getOrdersByLatLongSuccess(result)),
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
