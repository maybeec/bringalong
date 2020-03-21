import { TestBed, async } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { AppComponent } from './app.component';
import { BringingComponent } from './bringing/bringing.component';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { bringingReducer } from './bringing/bringing.reducer';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        FormsModule,
        StoreModule.forRoot({ bringing: bringingReducer })
      ],
      declarations: [
        AppComponent,
        BringingComponent
      ],
    }).compileComponents();
  }));

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'bringalong'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('bringalong');
  });
});
