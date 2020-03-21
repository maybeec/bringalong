import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { BringingState, selectPlz } from './bringing.state';
import { searchForPlz } from './bringing.actions';

@Component({
  selector: 'app-bringing',
  templateUrl: './bringing.component.html',
  styleUrls: ['./bringing.component.scss']
})
export class BringingComponent implements OnInit {

  public plz: string;

  constructor(private store: Store<BringingState>) { }

  ngOnInit(): void {
    console.log("ngOnInit",this.store);
    this.store.select('uiState', 'plz').subscribe((plz => this.plz = plz));
  }

  search(): void {
    console.log(this.plz);
    this.store.dispatch(searchForPlz({plz: this.plz}));
  }

}
