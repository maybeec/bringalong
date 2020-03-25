import { createAction, props } from '@ngrx/store';
import { BringDemandEto } from 'src/api/model/bringDemandEto';

export const createOrder = createAction('[NewOrder Component] createOrder', props<BringDemandEto>());
export const createOrderSuccess = createAction('[NewOrder Component] createOrder Success', props<BringDemandEto>()); // TODO:
export const createOrderError = createAction('[NewOrder Component] createOrder Error');
