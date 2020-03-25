import { createReducer, on } from '@ngrx/store';
import { initialState } from './new-order.state';


const newOrderReducerCreator = createReducer(initialState
);

export function newOrderReducer(state, action) {
    return newOrderReducerCreator(state, action);
}
