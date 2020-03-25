import { createAction, props } from '@ngrx/store';
import { UserProfileTo } from 'src/api/model/userProfileTo';


export const loggedOut = createAction('[App Component] loggedOut');

export const getUser = createAction('[App Component] getUser');
export const getUserSuccess = createAction('[App Component] getUser Success', props<UserProfileTo>());
export const getUserError = createAction('[App Component] getUser Error');
