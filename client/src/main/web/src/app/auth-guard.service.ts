import { Injectable } from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, interval } from 'rxjs';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';
import { debounce } from 'rxjs/operators';

@Injectable()
export class AuthGuardService implements CanActivate {
    constructor(private store: Store<AppState>) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
    : boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {
        return this.store.select(s => s.app.appState.loggedIn).pipe(debounce(() => interval(1000)));
    }
}
