import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SelectStoreComponent } from './select-store.component';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { selectStoreReducer } from './select-store.reducer';

describe('SelectStoreComponent', () => {
  let component: SelectStoreComponent;
  let fixture: ComponentFixture<SelectStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SelectStoreComponent ],
      imports: [
        FormsModule,
        StoreModule.forRoot({ selectStore: selectStoreReducer })
      ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SelectStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
