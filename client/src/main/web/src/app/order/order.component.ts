import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { getOrder, bringOrder } from './order.actions';
import { Observable } from 'rxjs';
import { Order } from 'src/api';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  id: number;
  order$: Observable<Order>;

  constructor(private store: Store<AppState>, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.order$ = this.store.select(state => state.order.appState.order);
    this.store.dispatch(getOrder({ id: this.id }));
  }

  bring(id: number): void {
    this.store.dispatch(bringOrder({ id: this.id }));
  }

}
