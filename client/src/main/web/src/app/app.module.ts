import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SelectStoreComponent } from './select-store/select-store.component';
import { selectStoreReducer } from './select-store/select-store.reducer';
import { SelectStoreEffects } from './select-store/select-store.effects';
import { environment } from 'src/environments/environment';
import { ApiModule, Configuration } from 'src/api';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { ModeComponent } from './mode/mode.component';
import { StoreOrdersComponent } from './store-orders/store-orders.component';
import { storeOrdersReducer } from './store-orders/store-orders.reducer';
import { StoreOrdersEffects } from './store-orders/store-orders.effects';

export function apiConfigFactory(): Configuration {
  return new Configuration();
}

const routes: Routes = [
  { path: '', component: ModeComponent },
  { path: 'bringing', component: SelectStoreComponent },
  { path: 'bringing/:id', component: StoreOrdersComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    SelectStoreComponent,
    ModeComponent,
    StoreOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ApiModule.forRoot(apiConfigFactory),
    StoreModule.forRoot({ selectStore: selectStoreReducer, storeOrders: storeOrdersReducer }),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
      logOnly: environment.production
    }),
    EffectsModule.forRoot([SelectStoreEffects, StoreOrdersEffects])
  ],
  providers: [],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
