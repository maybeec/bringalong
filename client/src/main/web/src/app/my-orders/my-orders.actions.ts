import { createAction, props } from '@ngrx/store';
import { GetOrdersResponse } from 'src/api';

export const getMyOrders = createAction('[MyOrders Component] getMyOrders');
export const getMyOrdersSuccess = createAction('[MyOrders Component] getMyOrders Success', props<GetOrdersResponse>());
export const getMyOrdersError = createAction('[MyOrders Component] getMyOrders Error');

