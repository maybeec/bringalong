import { createReducer, on } from '@ngrx/store';
import { initialState } from './edit-order.state';
import { getOrderForEditSuccess } from './edit-order.actions';


const editReducerCreator = createReducer(initialState,
    on(getOrderForEditSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                order: payload.order // TODO: payload übernehmen (auch state anpassen)
            }
        };
    })
);

export function editReducer(state, action) {
    return editReducerCreator(state, action);
}
