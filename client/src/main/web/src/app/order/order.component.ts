import { Component, OnInit } from '@angular/core';
import { Product } from 'src/api/model/product';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { OrderState } from './order.state';
import { loadProductsForStore } from './order.actions';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {

  id: number;
  products$: Observable<Product[]>;

  constructor(private route: ActivatedRoute, private store: Store<OrderState>) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.products$ = this.store.select('appState', 'products');
    this.store.dispatch(loadProductsForStore({id: this.id}));
  }

  order(): void {
  }
}
