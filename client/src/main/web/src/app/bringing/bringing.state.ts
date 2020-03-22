import { createSelector } from '@ngrx/store';
import { Store } from 'src/api';

export interface BringingUiState {
    plz: string;
}

export interface BringingAppState {
    stores: Store[];
}

export interface BringingState {
    uiState: BringingUiState;
    appState: BringingAppState;
}

export const initialState: BringingState = {
    uiState: {
        plz: '123'
    },
    appState: {
        stores: []
    }
};
