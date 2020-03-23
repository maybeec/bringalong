import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AppState } from '../app.state';
import { Store } from '@ngrx/store';
import { getOrderForEdit } from './edit-order.actions';

@Component({
  selector: 'app-edit-order',
  templateUrl: './edit-order.component.html',
  styleUrls: ['./edit-order.component.scss']
})
export class EditOrderComponent implements OnInit {
  id: number;
  order$: Observable<any>; // TODO:

  constructor(private store: Store<AppState>, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.id = +this.route.snapshot.paramMap.get('id');
    this.order$ = this.store.select(state => state.editOrder.appState.order);
    this.store.dispatch(getOrderForEdit({ id: this.id }));
  }

}
