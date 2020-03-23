import {
    HttpInterceptor,
    HttpRequest,
    HttpResponse,
    HttpErrorResponse,
    HttpHandler,
    HttpEvent
   } from '@angular/common/http';

import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { Injectable } from '@angular/core';
import { throwError } from 'rxjs';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';
import { loggedOut } from './app.actions';

@Injectable()
export class LoggedOutHttpInterceptor implements HttpInterceptor {
    constructor(private store: Store<AppState>) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        return next
            .handle(request)
            .catch(response => {
                if (response instanceof HttpErrorResponse && response.status === 403) {
                    this.store.dispatch(loggedOut());
                }
                return throwError(response);
            });
    }
}
