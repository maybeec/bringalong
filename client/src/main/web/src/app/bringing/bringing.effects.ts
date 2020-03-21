import { Injectable } from '@angular/core';
import { Actions, createEffect, ofType } from '@ngrx/effects';
import { of, Observable } from 'rxjs';
import { map, mergeMap, catchError } from 'rxjs/operators';
import { searchForPlz, searchForPlzSuccess, searchForPlzError } from './bringing.actions';
import { DefaultService, SearchStoresResult } from 'src/api';


@Injectable()
export class BringingEffects {

    searchForPlz$ = createEffect(() =>
        this.actions$.pipe(
            ofType(searchForPlz),
            mergeMap(
                (payload) => (this.service.searchStores(payload.plz, 'body') as Observable<SearchStoresResult>)
                .pipe(
                    map(result => searchForPlzSuccess(result)),
                    catchError(() => of(searchForPlzError()))
                )
            )
        )
    );

    constructor(
        private actions$: Actions,
        private service: DefaultService
    ) {}
}
