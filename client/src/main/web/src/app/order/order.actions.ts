import { createAction, props } from '@ngrx/store';
import { LoadProductsForStoreResult } from 'src/api';
import { CreateOrderRequest } from 'src/api/model/createOrderRequest';
import { CreateOrderResult } from 'src/api/model/createOrderResult';

export const loadProductsForStore = createAction('[Order Component] loadProductsForStore', props<{id: number }>());
export const loadProductsForStoreSuccess = createAction('[Order Component] loadProductsForStore Success',
                                                        props<LoadProductsForStoreResult>());
export const loadProductsForStoreError = createAction('[Order Component] loadProductsForStore Error');

export const createOrder = createAction('[Order Component] createOrder', props<{storeId: number, request: CreateOrderRequest }>());
export const createOrderSuccess = createAction('[Order Component] createOrder Success', props<CreateOrderResult>());
export const createOrderError = createAction('[Order Component] createOrder Error');

