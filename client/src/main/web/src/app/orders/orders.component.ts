import { Component, OnInit, OnDestroy } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { Observable, Subscription } from 'rxjs';
import { getOrdersByLatLong } from './orders.actions';
import { UserOrder } from 'src/api/model/userOrder';

declare function geoplugin_latitude(): number;
declare function geoplugin_longitude(): number;

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit, OnDestroy {

  orders$: Observable<UserOrder[]>;
  loggedInSubscription: Subscription;
  userSubscription: Subscription;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.orders$ = this.store.select(state => state.orders.appState.orders);
    this.loggedInSubscription = this.store.select(state => state.app.appState.loggedIn).subscribe(loggedIn => {
      if (!loggedIn) {
        if (navigator.geolocation) {
          const lat = localStorage.getItem('lat');
          const long = localStorage.getItem('long');
          if (lat != null && long != null) {
              this.getOrdersByLatLong(+lat, +long);
          } else {
            navigator.geolocation.getCurrentPosition(position => this.getOrdersByPosition(position), error => this.getOrdersByIpLatLong());
          }
        } else {
          this.getOrdersByIpLatLong();
        }
      }
    });
    this.userSubscription = this.store.select(state => state.app.appState.user).subscribe(user => {
      if (user) {
        this.getOrdersByLatLong(user.lat, user.lng);
      }
    });
  }

  ngOnDestroy(): void {
    this.loggedInSubscription.unsubscribe();
    this.userSubscription.unsubscribe();
  }

  getOrdersByPosition(position: Position): void {
    localStorage.setItem('lat', position.coords.latitude.toString());
    localStorage.setItem('long', position.coords.longitude.toString());
    this.getOrdersByLatLong(position.coords.latitude, position.coords.longitude);
  }

  getOrdersByIpLatLong(): void {
    this.getOrdersByLatLong(geoplugin_latitude(), geoplugin_longitude());
  }

  getOrdersByLatLong(lat: number, long: number): void {
    this.store.dispatch(getOrdersByLatLong({ lat, long}));
  }
}
