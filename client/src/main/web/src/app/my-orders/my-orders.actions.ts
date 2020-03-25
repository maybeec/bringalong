import { createAction, props } from '@ngrx/store';
import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export const getMyOrders = createAction('[MyOrders Component] getMyOrders');
export const getMyOrdersSuccess = createAction('[MyOrders Component] getMyOrders Success', props<{ orders: PageBringDemandEto[]}>());
export const getMyOrdersError = createAction('[MyOrders Component] getMyOrders Error');

