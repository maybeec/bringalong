import { createReducer, on } from '@ngrx/store';
import { initialState } from './store-orders.state';
import { getOrdersSuccess } from './store-orders.actions';


const storeOrdersReducerCreator = createReducer(initialState,
    on(getOrdersSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                orders: payload.orders
            }
        };
    })
);

export function storeOrdersReducer(state, action) {
    return storeOrdersReducerCreator(state, action);
}
