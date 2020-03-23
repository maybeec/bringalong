import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs-compat/Observable';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { getAcceptedOrders } from './accepted-orders.actions';

@Component({
  selector: 'app-accepted-orders',
  templateUrl: './accepted-orders.component.html',
  styleUrls: ['./accepted-orders.component.scss']
})
export class AcceptedOrdersComponent implements OnInit {
  orders$: Observable<any>; // TODO: Datentyp

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.orders$ = this.store.select(state => state.acceptedOrders.appState.orders);
    this.store.dispatch(getAcceptedOrders());
  }

}
