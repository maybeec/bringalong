import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, CurrentUserResponse } from 'src/api';
import { getUser, getUserSuccess, getUserError } from './app.actions';


@Injectable()
export class AppEffects {

    getUser$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getUser),
            mergeMap(
                () => (this.service.getCurrentUser('body') as Observable<CurrentUserResponse>)
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
