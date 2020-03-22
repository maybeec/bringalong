import { createReducer, on } from '@ngrx/store';
import { initialState } from './app.state';
import { createOrderSuccess } from './order/order.actions';


const appReducerCreator = createReducer(initialState,
    on(createOrderSuccess, (state, payload) => {
        return { ...state,
            uiState: {
                ...state.uiState,
                message: 'Ihre Bestellung wurde angelegt.'
            }
        };
    })
);

export function appReducer(state, action) {
    return appReducerCreator(state, action);
}
