import { createReducer, on } from '@ngrx/store';
import { initialState } from './order.state';
import { getOrderSuccess } from './order.actions';


const orderReducerCreator = createReducer(initialState,
    on(getOrderSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                order: payload.order // TODO: payload übernehmen (auch state anpassen)
            }
        };
    })
);

export function orderReducer(state, action) {
    return orderReducerCreator(state, action);
}
