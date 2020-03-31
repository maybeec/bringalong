import { Component, OnInit, OnDestroy } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';
import { Observable, Subscription } from 'rxjs';
import { getUser } from './app.actions';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy  {
  title = 'bringalong';
  message$: Observable<string>;
  loggedInSubscription: Subscription;

  constructor(private store: Store<AppState>, private router: Router) { }

  ngOnInit(): void {
    this.message$ = this.store.select(store => store.app.uiState.message);
    this.loggedInSubscription = this.store.select(state => state.app.appState.loggedIn).subscribe(loggedIn => {
      if (loggedIn) {
        this.store.dispatch(getUser());
      } else if (loggedIn === false) {
        if (!!localStorage.getItem('token')) {
          localStorage.removeItem('token');
          document.location.reload();
        }
      }
    });
    this.store.dispatch(getUser());
  }
  ngOnDestroy(): void {
    this.loggedInSubscription.unsubscribe();
  }
}
