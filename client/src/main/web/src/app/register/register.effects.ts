import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { DefaultService, RegisterResponse } from 'src/api';
import { register, registerSuccess, registerError, getLatLong, getLatLongSuccess, getLatLongError, GetLatLongResponse } from './register.actions';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class RegisterEffects {

    register$ = createEffect(() =>
        this.actions$.pipe(
            ofType(register),
            mergeMap(
                (payload) => (this.service.register(payload, 'body') as Observable<RegisterResponse>)
                .pipe(
                    map(result => registerSuccess(result)),
                    catchError(() => of(registerError()))
                )
            )
        )
    );

    getLatLong$ = createEffect(() =>
        this.actions$.pipe(
            ofType(getLatLong),
            mergeMap(
                (payload) => (this.httpClient.post<GetLatLongResponse>(
                    'http://www.mapquestapi.com/geocoding/v1/address?key=qvum0TVa1GmVjlk164wqXD9eYedtbRrt',
                payload,
                {
                    observe: 'body'
                }) as Observable<GetLatLongResponse>)
                .pipe(
                    map(result => getLatLongSuccess(result)),
                    catchError(() => of(getLatLongError()))
                )
            )
        )
    );


    constructor(
        private actions$: Actions,
        private service: DefaultService,
        private router: Router,
        private httpClient: HttpClient
    ) {}
}