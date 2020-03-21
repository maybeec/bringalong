import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BringingComponent } from './bringing.component';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { bringingReducer } from './bringing.reducer';

describe('BringingComponent', () => {
  let component: BringingComponent;
  let fixture: ComponentFixture<BringingComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BringingComponent ],
      imports: [
        FormsModule,
        StoreModule.forRoot({ bringing: bringingReducer })
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BringingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
