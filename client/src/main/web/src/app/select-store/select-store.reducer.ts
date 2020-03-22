import { createReducer, on } from '@ngrx/store';
import { searchForPlz, searchForPlzSuccess } from './select-store.actions';
import { initialState } from './select-store.state';


const selectStoreReducerCreator = createReducer(initialState,
    on(searchForPlz, (state, payload) => {
        return { ...state,
            uiState: {
                ...state.uiState,
                plz: payload.plz
            }
        };
    }),
    on(searchForPlzSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                stores: payload.stores
            }
        };
    })
);

export function selectStoreReducer(state, action) {
    return selectStoreReducerCreator(state, action);
}
