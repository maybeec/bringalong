import { createSelector } from '@ngrx/store';
import { Store } from 'src/api';

export interface BringingUiState {
    plz: string;
    stores: Store[];
}

export interface BringingAppState {
}

export interface BringingState {
    uiState: BringingUiState;
    appState: BringingAppState;
}

export const initialState: BringingState = {
    uiState: {
        plz: '123',
        stores: []
    },
    appState: {}
};
