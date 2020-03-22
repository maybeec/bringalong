import { createReducer, on } from '@ngrx/store';
import { searchForPlz, searchForPlzSuccess } from './bringing.actions';
import { initialState } from './bringing.state';


const bringingReducerCreator = createReducer(initialState,
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

export function bringingReducer(state, action) {
    return bringingReducerCreator(state, action);
}
