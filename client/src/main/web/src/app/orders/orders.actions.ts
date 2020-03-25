import { createAction, props } from '@ngrx/store';
import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export const getOrders = createAction('[Orders Component] getOrders');
export const getOrdersSuccess = createAction('[Orders Component] getOrders Success', props<{orders: PageBringDemandEto[]}>());
export const getOrdersError = createAction('[Orders Component] getOrders Error');

export const getOrdersByLatLong = createAction('[Orders Component] getOrdersByLatLong', props<{lat: number, long: number}>());
export const getOrdersByLatLongSuccess = createAction('[Orders Component] getOrdersByLatLong Success',
                                            props<{orders: PageBringDemandEto[]}>());
export const getOrdersByLatLongError = createAction('[Orders Component] getOrdersByLatLong Error');
