import { createAction, props } from '@ngrx/store';
import { CreateOrderRequest, CreateOrderResponse } from 'src/api';

export const createOrder = createAction('[NewOrder Component] createOrder', props<CreateOrderRequest>());
export const createOrderSuccess = createAction('[NewOrder Component] createOrder Success', props<CreateOrderResponse>()); // TODO:
export const createOrderError = createAction('[NewOrder Component] createOrder Error');
