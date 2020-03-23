import { createAction, props } from '@ngrx/store';

export const getOrderForEdit = createAction('[Edit Component] getOrderForEdit', props<{id: number}>());
export const getOrderForEditSuccess = createAction('[Edit Component] getOrderForEdit Success', props<any>()); // TODO:
export const getOrderForEditError = createAction('[Edit Component] getOrderForEdit Error');

export const deleteOrder = createAction('[Edit Component] deleteOrder', props<{id: number }>());
export const deleteOrderSuccess = createAction('[Edit Component] deleteOrder Success', props<any>()); // TODO:
export const deleteOrderError = createAction('[Edit Component] deleteOrder Error');
