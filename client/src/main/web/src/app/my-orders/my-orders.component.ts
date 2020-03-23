import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { Observable } from 'rxjs';
import { getMyOrders } from './my-orders.actions';

@Component({
  selector: 'app-my-orders',
  templateUrl: './my-orders.component.html',
  styleUrls: ['./my-orders.component.scss']
})
export class MyOrdersComponent implements OnInit {
  orders$: Observable<any>; // TODO: Datentyp

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.orders$ = this.store.select(state => state.myOrders.appState.orders);
    this.store.dispatch(getMyOrders());
  }

}
