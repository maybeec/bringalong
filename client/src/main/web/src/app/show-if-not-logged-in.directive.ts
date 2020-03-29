import { Directive, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';
import { Subscription } from 'rxjs';

@Directive({
  selector: '[appShowIfNotLoggedIn]'
})
export class ShowIfNotLoggedInDirective implements OnInit, OnDestroy {
 
  loggedInSubscription: Subscription;
 
  constructor(private el: ElementRef, private store: Store<AppState>) { }

  ngOnInit() {
    this.loggedInSubscription = this.store.select(state => state.app.appState.loggedIn).subscribe(loggedIn => {
      if (loggedIn) {
        this.el.nativeElement.style.display = 'none';
      }
    });
  }

  ngOnDestroy(): void {
    this.loggedInSubscription.unsubscribe();
  }
}
