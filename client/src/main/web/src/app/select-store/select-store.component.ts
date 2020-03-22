import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Store as ApiStore } from 'src/api';
import { searchForPlz } from './select-store.actions';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AppState } from '../app.state';

@Component({
  selector: 'app-select-store',
  templateUrl: './select-store.component.html',
  styleUrls: ['./select-store.component.scss']
})
export class SelectStoreComponent implements OnInit {

  public plz: string;

  public stores$: Observable<ApiStore[]>;

  public mode: string;

  constructor(private route: ActivatedRoute, private store: Store<AppState>) { }

  ngOnInit(): void {
    this.store.select('selectStore', 'uiState', 'plz').subscribe(plz => this.plz = plz);
    this.stores$ = this.store.select('selectStore', 'appState', 'stores');
    this.mode = this.route.snapshot.url[0].path;
  }

  search(): void {
    this.store.dispatch(searchForPlz({plz: this.plz}));
  }

}
