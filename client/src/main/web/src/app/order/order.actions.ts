import { createAction, props } from '@ngrx/store';
import { GetOrderResponse } from 'src/api';

export const getOrder = createAction('[Order Component] getOrder', props<{id: string}>());
export const getOrderSuccess = createAction('[Order Component] getOrder Success', props<GetOrderResponse>()); // TODO:
export const getOrderError = createAction('[Order Component] getOrder Error');

export const bringOrder = createAction('[Order Component] bringOrder', props<{id: string }>());
export const bringOrderSuccess = createAction('[Order Component] bringOrder Success', props<any>()); // TODO:
export const bringOrderError = createAction('[Order Component] bringOrder Error');
