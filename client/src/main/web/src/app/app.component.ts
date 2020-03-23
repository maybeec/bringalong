import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';
import { Observable } from 'rxjs';
import { getUser } from './app.actions';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit  {
  title = 'bringalong';
  message$: Observable<string>;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.message$ = this.store.select(store => store.app.uiState.message);
    this.store.dispatch(getUser());
  }
}
