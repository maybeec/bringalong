import { createReducer, on } from '@ngrx/store';
import { searchForPlz } from './bringing.actions';
import { initialState } from './bringing.state';


const _bringingReducer = createReducer(initialState,
    on(searchForPlz, (state, payload) => {
        return { ...state,
            uiState: {
                ...state.uiState,
                plz: payload.plz
            }
        };
    }),
);

export function bringingReducer(state, action) {
    return _bringingReducer(state, action);
}
