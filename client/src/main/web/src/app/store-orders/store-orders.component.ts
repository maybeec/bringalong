import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { getOrders, bringOrder } from './store-orders.actions';
import { Store } from '@ngrx/store';
import { Observable } from 'rxjs';
import { StoreOrder } from 'src/api';
import { AppState } from '../app.state';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-store-orders',
  templateUrl: './store-orders.component.html',
  styleUrls: ['./store-orders.component.scss']
})
export class StoreOrdersComponent implements OnInit {
  id: number;
  orders$: Observable<StoreOrder[]>;

  constructor(private route: ActivatedRoute, private store: Store<AppState>) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.orders$ = this.store.select('storeOrders', 'appState', 'orders')
                        .pipe(map(orders => {
                          orders.sort((a, b) => {
                            if (a.pickupcode != null) {
                              return -1;
                            }
                            if (b.pickupcode != null) {
                              return 1;
                            }
                            return 0;
                          } );
                          return orders;
                        }));
    this.store.dispatch(getOrders({id: this.id}));
  }
  bring(id: number): void {
    this.store.dispatch(bringOrder({id}));
  }
}
