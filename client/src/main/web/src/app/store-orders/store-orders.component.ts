import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { loadOrders } from './store-orders.actions';
import { Store } from '@ngrx/store';
import { StoreOrdersState } from './store-orders.state';
import { Observable } from 'rxjs';
import { StoreOrder } from 'src/api';

@Component({
  selector: 'app-store-orders',
  templateUrl: './store-orders.component.html',
  styleUrls: ['./store-orders.component.scss']
})
export class StoreOrdersComponent implements OnInit {
  id: number;
  orders$: Observable<StoreOrder[]>;

  constructor(private route: ActivatedRoute, private store: Store<StoreOrdersState>) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.orders$ = this.store.select('appState', 'orders');
    this.store.dispatch(loadOrders({id: this.id}));
  }
}
