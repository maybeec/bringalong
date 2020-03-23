import { createReducer, on } from '@ngrx/store';
import { initialState } from './orders.state';
import { getOrdersSuccess } from './orders.actions';


const ordersReducerCreator = createReducer(initialState,
    on(getOrdersSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                orders: payload.orders
            }
        };
    })
);

export function ordersReducer(state, action) {
    return ordersReducerCreator(state, action);
}
