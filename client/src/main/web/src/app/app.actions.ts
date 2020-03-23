import { createAction, props } from '@ngrx/store';


export const loggedOut = createAction('[App Component] loggedOut');

export const getUser = createAction('[App Component] getUser');
export const getUserSuccess = createAction('[App Component] getUser Success', props<any>());
export const getUserError = createAction('[App Component] getUser Error');
