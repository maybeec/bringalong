import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { createOrder } from './new-order.actions';

@Component({
  selector: 'app-new-order',
  templateUrl: './new-order.component.html',
  styleUrls: ['./new-order.component.scss']
})
export class NewOrderComponent implements OnInit {

  item: string;
  dropHint: string;
  estimatedAmount: number; // TODO: dropdown drauß machen
  endDateTime: string;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.endDateTime = moment().format('YYYY-MM-DD HH:mm');
  }

  order(): void {
    this.store.dispatch(createOrder({ order: {
                                        text: this.item,
                                        dropHint: this.dropHint,
                                        estimatedAmount: this.estimatedAmount,
                                        deadline: moment(this.endDateTime).toString(),
                                        currency: 'Euro'}})); // TODO:
  }
}
