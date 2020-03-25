import { createReducer, on } from '@ngrx/store';
import { initialState } from './app.state';
import { loggedOut, getUserSuccess, getUserError } from './app.actions';

const genericErrorMessage = 'Es ist ein Fehler aufgetreten. Bitte versuchen Sie es erneut.';
function setGenericErrorMessage(state) {
    return { ...state,
        uiState: {
            ...state.uiState,
            message: genericErrorMessage
        }
    };
}

const appReducerCreator = createReducer(initialState,
    on(loggedOut, state => {
        return {
            ... state,
            appState: {
                ... state.appState,
                loggedIn: false
            }
        };
    }),
    on(getUserSuccess, (state, payload) => {
        return {
            ... state,
            appState: {
                ... state.appState,
                loggedIn: true,
                user: payload
            }
        };
    }),
    on(getUserError, (state) => {
        return {
            ... state,
            appState: {
                ... state.appState,
                loggedIn: false
            }
        };
    })
);

export function appReducer(state, action) {
    return appReducerCreator(state, action);
}
