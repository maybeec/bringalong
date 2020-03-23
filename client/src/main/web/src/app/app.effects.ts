import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, GetStoreOrdersResult, BringOrderResult } from 'src/api';
import { getUser, getUserSuccess, getUserError } from './app.actions';


@Injectable()
export class AppEffects {

    getUser$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getUser),
            mergeMap(
                (payload) => (this.service.getStoreOrders(1, 'body') as Observable<GetStoreOrdersResult>) // TODO: richtige FKT
                .pipe(
                    map(result => getUserSuccess(result)),
                    catchError(() => of(getUserError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
