import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { StoreModule } from '@ngrx/store';
import { EffectsModule } from '@ngrx/effects';
import { StoreDevtoolsModule } from '@ngrx/store-devtools';

import { AppComponent } from './app.component';
import { environment } from 'src/environments/environment';
import { ApiModule, Configuration } from 'src/api';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { appReducer } from './app.reducer';
import { OrdersComponent } from './orders/orders.component';
import { ordersReducer } from './orders/orders.reducer';
import { MyOrdersComponent } from './my-orders/my-orders.component';
import { myOrdersReducer } from './my-orders/my-orders.reducer';
import { OrdersEffects } from './orders/orders.effects';
import { MyOrdersEffects } from './my-orders/my-orders.effects';
import { NewOrderComponent } from './new-order/new-order.component';
import { AuthGuardService } from './auth-guard.service';
import { HideIfNotLoggedInDirective } from './hide-if-not-logged-in.directive';
import { LoggedOutHttpInterceptor } from './logged-out-http.interceptor';
import { AppEffects } from './app.effects';
import { OrderComponent } from './order/order.component';
import { orderReducer } from './order/order.reducer';
import { OrderEffects } from './order/order.effects';
import { EditOrderComponent } from './edit-order/edit-order.component';
import { AcceptedOrdersComponent } from './accepted-orders/accepted-orders.component';
import { acceptedOrdersReducer } from './accepted-orders/accepted-orders.reducer';
import { AcceptedOrdersEffects } from './accepted-orders/accepted-orders.effects';
import { editReducer } from './edit-order/edit-order.reducer';
import { EditOrderEffects } from './edit-order/edit-order.effects';
import { newOrderReducer } from './new-order/new-order.reducer';
import { NewOrderEffects } from './new-order/new-order.effects';
import { LoginComponent } from './login/login.component';
import { ShowIfNotLoggedInDirective } from './show-if-not-logged-in.directive';
import { LoginEffects } from './login/login.effects';
import { loginReducer } from './login/login.reducer';
import { RegisterComponent } from './register/register.component';
import { RegisterEffects } from './register/register.effects';
import { registerReducer } from './register/register.reducer';

export function apiConfigFactory(): Configuration {
  const config = new Configuration({
    basePath: '/rest',
    apiKeys: {  }
  });
  if (localStorage.getItem('token')) {
    config.apiKeys = { Authorization: 'Bearer ' + localStorage.getItem('token') };
  }
  return config;
}

const routes: Routes = [
  { path: '', component: OrdersComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'orders', component: OrdersComponent },
  { path: 'orders/:id', component: OrderComponent },
  { path: 'myOrders', component: MyOrdersComponent, canActivate: [AuthGuardService] },
  { path: 'myOrders/new', component: NewOrderComponent, canActivate: [AuthGuardService] },
  { path: 'myOrders/:id', component: EditOrderComponent, canActivate: [AuthGuardService] },
  { path: 'acceptedOrders', component: AcceptedOrdersComponent, canActivate: [AuthGuardService] },
  { path: 'acceptedOrders/:id', component: OrderComponent, canActivate: [AuthGuardService] },
];

@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent,
    MyOrdersComponent,
    NewOrderComponent,
    HideIfNotLoggedInDirective,
    ShowIfNotLoggedInDirective,
    OrderComponent,
    EditOrderComponent,
    AcceptedOrdersComponent,
    LoginComponent,
    RegisterComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    ApiModule.forRoot(apiConfigFactory),
    StoreModule.forRoot({app: appReducer,
                        orders: ordersReducer,
                        myOrders: myOrdersReducer,
                        order: orderReducer,
                        acceptedOrders: acceptedOrdersReducer,
                        editOrder: editReducer,
                        newOrder: newOrderReducer,
                        login: loginReducer,
                        register: registerReducer }),
    StoreDevtoolsModule.instrument({
      maxAge: 25,
      logOnly: environment.production
    }),
    EffectsModule.forRoot([AppEffects,
                          OrdersEffects,
                          MyOrdersEffects,
                          OrderEffects,
                          AcceptedOrdersEffects,
                          EditOrderEffects,
                          NewOrderEffects,
                          LoginEffects,
                          RegisterEffects])
  ],
  providers: [
    AuthGuardService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: LoggedOutHttpInterceptor,
      multi: true
    }
  ],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule { }
