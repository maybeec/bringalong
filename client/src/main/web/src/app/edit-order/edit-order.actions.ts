import { createAction, props } from '@ngrx/store';
import { DeleteOrderResponse, GetOrderResponse } from 'src/api';

export const getOrderForEdit = createAction('[Edit Component] getOrderForEdit', props<{id: string}>());
export const getOrderForEditSuccess = createAction('[Edit Component] getOrderForEdit Success', props<GetOrderResponse>()); // TODO:
export const getOrderForEditError = createAction('[Edit Component] getOrderForEdit Error');

export const deleteOrder = createAction('[Edit Component] deleteOrder', props<{id: string }>());
export const deleteOrderSuccess = createAction('[Edit Component] deleteOrder Success', props<DeleteOrderResponse>()); // TODO:
export const deleteOrderError = createAction('[Edit Component] deleteOrder Error');
