import { createReducer, on } from '@ngrx/store';
import { initialState } from './my-orders.state';
import { getMyOrdersSuccess } from './my-orders.actions';


const myOrdersReducerCreator = createReducer(initialState,
    on(getMyOrdersSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                orders: payload.orders
            }
        };
    })
);

export function myOrdersReducer(state, action) {
    return myOrdersReducerCreator(state, action);
}
