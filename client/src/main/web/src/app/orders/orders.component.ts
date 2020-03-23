import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { Observable } from 'rxjs';
import { StoreOrder } from 'src/api';
import { getOrders, getOrdersByLatLong } from './orders.actions';

declare function geoplugin_latitude(): number;
declare function geoplugin_longitude(): number;

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {

  orders$: Observable<StoreOrder[]>;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.orders$ = this.store.select(state => state.orders.appState.orders);
    this.store.select(state => state.app.appState.loggedIn).subscribe(loggedIn => {
      if (loggedIn === false) {
        if (navigator.geolocation) {
          navigator.geolocation.getCurrentPosition(position => this.getOrdersByPosition(position), error => this.getOrdersByIpLatLong());
        } else {
          this.getOrdersByIpLatLong();
        }
      } else if (loggedIn === true) {
        this.store.dispatch(getOrders());
      }
    });
  }
  getOrdersByPosition(position: Position): void {
    this.getOrdersByLatLong(position.coords.latitude, position.coords.longitude);
  }

  getOrdersByIpLatLong(): void {
    this.getOrdersByLatLong(geoplugin_latitude(), geoplugin_longitude());
  }

  getOrdersByLatLong(lat: number, long: number): void {
    this.store.dispatch(getOrdersByLatLong({ lat, long}));
  }
}
