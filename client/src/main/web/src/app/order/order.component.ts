import { Component, OnInit } from '@angular/core';
import { Product } from 'src/api/model/product';
import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { loadProductsForStore, createOrder } from './order.actions';
import { AppState } from '../app.state';
import { map } from 'rxjs/operators';
import { CreateOrderRequest } from 'src/api/model/createOrderRequest';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  id: number;
  products$: Observable<Product[]>;
  orderItems: number[];

  constructor(private route: ActivatedRoute, private router: Router, private store: Store<AppState>) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.products$ = this.store.select('order', 'appState', 'products');
    this.products$.subscribe(products => {
      this.orderItems = [];
      products.forEach((product, index) => {
        this.orderItems[index] = 0;
      });
    });
    this.store.dispatch(loadProductsForStore({id: this.id}));
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
    this.store.dispatch(createOrder({storeId: this.id, request: {orderItems}}));
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
