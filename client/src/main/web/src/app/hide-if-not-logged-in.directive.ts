import { Directive, OnInit, ElementRef } from '@angular/core';
import { Store } from '@ngrx/store';
import { AppState } from './app.state';

@Directive({
  selector: '[appHideIfNotLoggedIn]'
})
export class HideIfNotLoggedInDirective implements OnInit {

  constructor(private el: ElementRef, private store: Store<AppState>) { }

  ngOnInit() {
    this.store.select(state => state.app.appState.loggedIn).subscribe(loggedIn => {
      if (!loggedIn) {
          this.el.nativeElement.style.display = 'none';
      }
    });
  }
}
