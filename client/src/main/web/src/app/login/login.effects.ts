import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, LoginResponse } from 'src/api';
import { login, loginSuccess, loginError } from './login.actions';
import { Router } from '@angular/router';

@Injectable()
export class LoginEffects {

    login$ = createEffect(() =>
        this.actions$.pipe(
            ofType(login),
            mergeMap(
                (payload) => (this.service.login(payload, 'body') as Observable<LoginResponse>)
                .pipe(
                    map(result => {
                        this.service.configuration.apiKeys = { Authorization: 'Bearer ' + result.token };
                        localStorage.setItem('token', result.token);
                        this.router.navigate(['']);
                        return loginSuccess(result);
                    }),
                    catchError(() => of(loginError()))
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
