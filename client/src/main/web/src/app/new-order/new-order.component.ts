import { Component, OnInit } from '@angular/core';
import * as moment from 'moment';

@Component({
  selector: 'app-new-order',
  templateUrl: './new-order.component.html',
  styleUrls: ['./new-order.component.scss']
})
export class NewOrderComponent implements OnInit {

  item: string;
  dropHint: string;
  estimatedAmount: string;
  endDateTime: string;

  constructor() { }

  ngOnInit(): void {
    this.endDateTime = moment().format('YYYY-MM-DD HH:mm');
  }

  order(): void {
  }

}
