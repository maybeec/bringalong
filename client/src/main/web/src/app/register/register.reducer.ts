import { createReducer, on } from '@ngrx/store';
import { initialState } from './register.state';
import { registerSuccess, getLatLongSuccess } from './register.actions';


const registerReducerCreator = createReducer(initialState,
    on(getLatLongSuccess, (state, payload) => {
        return { ...state,
            appState: {
                ...state.appState,
                coordinates: payload.results[0].locations[0].latLng
            }
        };
    })
    );

export function registerReducer(state, action) {
    return registerReducerCreator(state, action);
}
