import { createReducer, on } from '@ngrx/store';
import { getProductsForStoreSuccess } from './order.actions';
import { initialState } from './order.state';


const orderReducerCreator = createReducer(initialState,
    on(getProductsForStoreSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                products: payload.products
            }
        };
    })
);

export function orderReducer(state, action) {
    return orderReducerCreator(state, action);
}
