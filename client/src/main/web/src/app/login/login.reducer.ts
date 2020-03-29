import { createReducer, on } from '@ngrx/store';
import { initialState } from './login.state';
import { loginSuccess } from './login.actions';


const loginReducerCreator = createReducer(initialState);

export function loginReducer(state, action) {
    return loginReducerCreator(state, action);
}
