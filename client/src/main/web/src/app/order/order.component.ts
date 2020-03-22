import { Component, OnInit } from '@angular/core';
import { Product } from 'src/api/model/product';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { getProductsForStore, createOrder } from './order.actions';
import { AppState } from '../app.state';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  id: number;
  products$: Observable<Product[]>;
  orderItems: number[];
  startDate: string;
  startTime: string;
  endDate: string;
  endTime: string;

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<AppState>) { }

  ngOnInit(): void {
    const now = moment();
    this.startDate = now.format('YYYY-MM-DD');
    this.startTime = now.format('HH:mm');
    this.endDate = now.add(1, 'days').format('YYYY-MM-DD');
    this.endTime = now.add(1, 'days').format('HH:mm');

    this.id = +this.route.snapshot.paramMap.get('id');
    this.products$ = this.store.select('order', 'appState', 'products');
    this.products$.subscribe(products => {
      this.orderItems = [];
      products.forEach((product, index) => {
        this.orderItems[index] = 0;
      });
    });
    this.store.dispatch(getProductsForStore({id: this.id}));
  }

  order(): void {
    let orderItems = [];
    this.products$.subscribe((products) => {
      orderItems = [];
      products.forEach((product, index) => {
        if (this.orderItems[index] > 0) {
          orderItems.push({productId: product.id, amount: this.orderItems[index]});
        }
      });
    });
    this.store.dispatch(createOrder({storeId: this.id, request: {orderItems,
                                                                startDate: this.startDate,
                                                                startTime: this.startTime,
                                                                endDate: this.endDate,
                                                                endTime: this.endTime}}));
    this.router.navigate(['/']);
  }

  sum(): Observable<number> {
    return this.products$.pipe(map((products) => {
      let sum = 0;
      products.forEach((product, index) => {
        sum += this.orderItems[index] * product.price;
      });
      return sum;
    }));
  }
}
