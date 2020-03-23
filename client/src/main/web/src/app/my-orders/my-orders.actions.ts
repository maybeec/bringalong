import { createAction, props } from '@ngrx/store';
import { GetStoreOrdersResult } from 'src/api';

export const getMyOrders = createAction('[MyOrders Component] getMyOrders');
export const getMyOrdersSuccess = createAction('[MyOrders Component] getMyOrders Success', props<any>()); //TODO:
export const getMyOrdersError = createAction('[MyOrders Component] getMyOrders Error');

