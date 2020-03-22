import { createAction, props } from '@ngrx/store';
import { GetStoreOrdersResult, BringOrderResult } from 'src/api';

export const getOrders = createAction('[Store Orders Component] getOrders', props<{id: number }>());
export const getOrdersSuccess = createAction('[Store Orders Component] getOrders Success', props<GetStoreOrdersResult>());
export const getOrdersError = createAction('[Store Orders Component] getOrders Error');

export const bringOrder = createAction('[Store Orders Component] bringOrder', props<{id: number }>());
export const bringOrderSuccess = createAction('[Store Orders Component] bringOrder Success', props<BringOrderResult>());
export const bringOrderError = createAction('[Store Orders Component] bringOrder Error');

