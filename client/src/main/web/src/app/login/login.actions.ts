import { createAction, props } from '@ngrx/store';
import { LoginRequest, LoginResponse } from 'src/api';

export const login = createAction('[Login Component] login', props<LoginRequest>());
export const loginSuccess = createAction('[Login Component] login Success', props<LoginResponse>()); // TODO:
export const loginError = createAction('[Login Component] login Error');
