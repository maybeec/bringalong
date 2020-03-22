import { createAction, props } from '@ngrx/store';
import { LoadStoreOrdersResult } from 'src/api';

export const loadOrders = createAction('[Store Orders Component] loadOrders', props<{id: number }>());
export const loadOrdersSuccess = createAction('[Store Orders Component] loadOrders Success', props<LoadStoreOrdersResult>());
export const loadOrdersError = createAction('[Store Orders Component] loadOrders Error');

