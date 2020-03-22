import { createAction, props } from '@ngrx/store';
import { GetProductsForStoreResult } from 'src/api';
import { CreateOrderRequest } from 'src/api/model/createOrderRequest';
import { CreateOrderResult } from 'src/api/model/createOrderResult';

export const getProductsForStore = createAction('[Order Component] getProductsForStore', props<{id: number }>());
export const getProductsForStoreSuccess = createAction('[Order Component] getProductsForStore Success',
                                                        props<GetProductsForStoreResult>());
export const getProductsForStoreError = createAction('[Order Component] getProductsForStore Error');

export const createOrder = createAction('[Order Component] createOrder', props<{storeId: number, request: CreateOrderRequest }>());
export const createOrderSuccess = createAction('[Order Component] createOrder Success', props<CreateOrderResult>());
export const createOrderError = createAction('[Order Component] createOrder Error');

