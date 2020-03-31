import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { getOrder, bringOrder } from './order.actions';
import { Observable } from 'rxjs';
import { Order, User } from 'src/api';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.scss']
})
export class OrderComponent implements OnInit {
  id: string;
  order$: Observable<Order>;
  user$: Observable<User>;
  currentUser$: Observable<User>;

  constructor(private store: Store<AppState>, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.paramMap.get('id');
    this.order$ = this.store.select(state => state.order.appState.order);
    this.user$ = this.store.select(state => state.order.appState.user);
    this.currentUser$ = this.store.select(state => state.app.appState.user);
    this.store.dispatch(getOrder({ id: this.id }));
  }

  bring(): void {
    this.store.dispatch(bringOrder({ id: this.id }));
  }

}
