import { createAction, props } from '@ngrx/store';
import { GetStoreOrdersResult, BringOrderResult } from 'src/api';

export const getOrders = createAction('[Orders Component] getOrders');
export const getOrdersSuccess = createAction('[Orders Component] getOrders Success', props<GetStoreOrdersResult>());
export const getOrdersError = createAction('[Orders Component] getOrders Error');

export const getOrdersByLatLong = createAction('[Orders Component] getOrdersByLatLong', props<{lat: number, long: number}>());
export const getOrdersByLatLongSuccess = createAction('[Orders Component] getOrdersByLatLong Success', props<GetStoreOrdersResult>());
export const getOrdersByLatLongError = createAction('[Orders Component] getOrdersByLatLong Error');
