import { Component, OnInit, OnDestroy } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from '../app.state';
import { register, getLatLong } from './register.actions';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit, OnDestroy {
  email = '';
  password = '';
  passwordRepeat = '';
  street = '';
  number = '';
  zipcode = '';
  city = '';
  coordinatesSubscription: Subscription;

  constructor(private store: Store<AppState>) { }

  ngOnInit(): void {
    this.email = 'test@blubb.com';
    this.coordinatesSubscription = this.store.select(state => state.register.appState.coordinates).subscribe(coordinates => {
      if (coordinates) {
        this.store.dispatch(register({ email: this.email, password: this.password, user: {
          lat: coordinates.lat, lng: coordinates.lng, number: +this.number, street: this.street,
          zipcode: this.zipcode, city: this.city  }}));
        console.log('coords', coordinates);
      }
    });
  }

  ngOnDestroy(): void {
    this.coordinatesSubscription.unsubscribe();
  }

  register(): void {
    this.store.dispatch(getLatLong({location: this.street + ' ' + this.number + ', ' + this.zipcode + ' ' + this.city}));
  }

  canRegister(): boolean {
    return this.password === this.passwordRepeat
      && this.email.length > 0
      && this.password.length > 0;
  }
}
