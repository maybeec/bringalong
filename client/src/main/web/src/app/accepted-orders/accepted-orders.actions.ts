import { createAction, props } from '@ngrx/store';
import { GetStoreOrdersResult } from 'src/api';

export const getAcceptedOrders = createAction('[AcceptedOrders Component] getAcceptedOrders');
export const getAcceptedOrdersSuccess = createAction('[AcceptedOrders Component] getAcceptedOrders Success', props<any>()); //TODO:
export const getAcceptedOrdersError = createAction('[AcceptedOrders Component] getAcceptedOrders Error');

