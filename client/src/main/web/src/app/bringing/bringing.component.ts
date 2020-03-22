import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Store as ApiStore } from 'src/api';
import { BringingState } from './bringing.state';
import { searchForPlz } from './bringing.actions';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-bringing',
  templateUrl: './bringing.component.html',
  styleUrls: ['./bringing.component.scss']
})
export class BringingComponent implements OnInit {

  public plz: string;

  public stores$: Observable<ApiStore[]>;

  constructor(private store: Store<BringingState>) { }

  ngOnInit(): void {
    this.store.select('uiState', 'plz').subscribe((plz => this.plz = plz));
    this.stores$ = this.store.select('appState', 'stores');
  }

  search(): void {
    this.store.dispatch(searchForPlz({plz: this.plz}));
  }

}
