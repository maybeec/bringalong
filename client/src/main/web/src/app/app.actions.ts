import { createAction, props } from '@ngrx/store';
import { CurrentUserResponse } from 'src/api';


export const loggedOut = createAction('[App Component] loggedOut');

export const getUser = createAction('[App Component] getUser');
export const getUserSuccess = createAction('[App Component] getUser Success', props<CurrentUserResponse>());
export const getUserError = createAction('[App Component] getUser Error');
