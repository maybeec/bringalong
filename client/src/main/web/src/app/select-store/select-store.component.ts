import { Component, OnInit } from '@angular/core';
import { Store, select } from '@ngrx/store';
import { Store as ApiStore } from 'src/api';
import { SelectStoreState } from './select-store.state';
import { searchForPlz } from './select-store.actions';
import { Observable } from 'rxjs';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-select-store',
  templateUrl: './select-store.component.html',
  styleUrls: ['./select-store.component.scss']
})
export class SelectStoreComponent implements OnInit {

  public plz: string;

  public stores$: Observable<ApiStore[]>;

  public mode: string;

  constructor(private route: ActivatedRoute, private store: Store<SelectStoreState>) { }

  ngOnInit(): void {
    this.store.select('uiState', 'plz').subscribe((plz => this.plz = plz));
    this.stores$ = this.store.select('appState', 'stores');
    this.mode = this.route.snapshot.url[0].path;
  }

  search(): void {
    this.store.dispatch(searchForPlz({plz: this.plz}));
  }

}
