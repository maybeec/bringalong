import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BringingComponent } from './bringing/bringing.component';
import { bringingReducer } from './bringing/bringing.reducer';
import { BringingEffects } from './bringing/bringing.effects';
import { environment } from 'src/environments/environment';
import { ApiModule, Configuration } from 'src/api';
import { HttpClientModule } from '@angular/common/http';

export function apiConfigFactory(): Configuration {
  return new Configuration();
}

@NgModule({
  declarations: [
    AppComponent,
    BringingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ApiModule.forRoot(apiConfigFactory),
    StoreModule.forRoot({ bringing: bringingReducer }),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
      logOnly: environment.production
    }),
    EffectsModule.forRoot([BringingEffects])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
