import { createAction, props } from '@ngrx/store';
import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export const getAcceptedOrders = createAction('[AcceptedOrders Component] getAcceptedOrders', props<{id: number}>());
export const getAcceptedOrdersSuccess = createAction('[AcceptedOrders Component] getAcceptedOrders Success',
                                            props<{orders: PageBringDemandEto[]}>());
export const getAcceptedOrdersError = createAction('[AcceptedOrders Component] getAcceptedOrders Error');

