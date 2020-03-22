import { createAction, props } from '@ngrx/store';
import { GetStoreOrdersResult } from 'src/api';

export const getOrders = createAction('[Store Orders Component] getOrders', props<{id: number }>());
export const getOrdersSuccess = createAction('[Store Orders Component] getOrders Success', props<GetStoreOrdersResult>());
export const getOrdersError = createAction('[Store Orders Component] getOrders Error');

