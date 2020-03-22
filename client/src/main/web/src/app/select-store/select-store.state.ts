import { Store } from 'src/api';

export interface SelectStoreUiState {
    plz: string;
}

export interface SelectStoreAppState {
    stores: Store[];
}

export interface SelectStoreState {
    uiState: SelectStoreUiState;
    appState: SelectStoreAppState;
}

export const initialState: SelectStoreState = {
    uiState: {
        plz: '123'
    },
    appState: {
        stores: []
    }
};
