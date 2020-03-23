export interface EditOrderAppState {
    order: any; // TODO: neuen Datentyp
}

export interface EditOrderState {
    appState: EditOrderAppState;
}

export const initialState: EditOrderState = {
    appState: {
        order: {}
    }
};
