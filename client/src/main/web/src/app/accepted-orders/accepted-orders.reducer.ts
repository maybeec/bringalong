import { createReducer, on } from '@ngrx/store';
import { initialState } from './accepted-orders.state';
import { getAcceptedOrdersSuccess } from './accepted-orders.actions';


const acceptedOrdersReducerCreator = createReducer(initialState,
    on(getAcceptedOrdersSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                orders: payload.orders
            }
        };
    })
);

export function acceptedOrdersReducer(state, action) {
    return acceptedOrdersReducerCreator(state, action);
}
