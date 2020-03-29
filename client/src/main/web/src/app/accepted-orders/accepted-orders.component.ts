import { Component, OnInit, OnDestroy } from '@angular/core';
import { Observable } from 'rxjs-compat/Observable';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { UserOrder } from 'src/api';
import { getAcceptedOrders } from './accepted-orders.actions';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-accepted-orders',
  templateUrl: './accepted-orders.component.html',
  styleUrls: ['./accepted-orders.component.scss']
})
export class AcceptedOrdersComponent implements OnInit, OnDestroy {
  orders$: Observable<UserOrder[]>;
  loggedInSubscription: Subscription;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.orders$ = this.store.select(state => state.acceptedOrders.appState.orders);
    this.loggedInSubscription = this.store.select(state => state.app.appState.user).subscribe(user => {
      this.store.dispatch(getAcceptedOrders());
    });
  }

  ngOnDestroy(): void {
    this.loggedInSubscription.unsubscribe();
  }
}
