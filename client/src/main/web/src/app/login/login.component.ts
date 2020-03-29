import { Component, OnInit } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { login } from './login.actions';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  email: string;
  password: string;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.email = 'test@blubb.com';
  }

  login(): void {
    this.store.dispatch(login({ login: this.email, password: this.password}));
  }
}
