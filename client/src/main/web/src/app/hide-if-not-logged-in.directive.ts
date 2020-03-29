import { Directive, OnInit, ElementRef, OnDestroy } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';
import { Subscription } from 'rxjs';

@Directive({
  selector: '[appHideIfNotLoggedIn]'
})
export class HideIfNotLoggedInDirective implements OnInit, OnDestroy {

  loggedInSubscription: Subscription;
  originalValue: any;

  constructor(private el: ElementRef, private store: Store<AppState>) { }

  ngOnInit() {
    this.originalValue = this.el.nativeElement.style.display;
    this.loggedInSubscription = this.store.select(state => state.app.appState.loggedIn).subscribe(loggedIn => {
      if (!loggedIn) {
        this.el.nativeElement.style.display = 'none';
      } else {
        this.el.nativeElement.style.display = this.originalValue;
      }
    });
  }

  ngOnDestroy(): void {
    this.loggedInSubscription.unsubscribe();
  }
}
