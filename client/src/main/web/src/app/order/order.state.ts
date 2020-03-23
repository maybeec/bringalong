export interface OrderAppState {
    order: any; // TODO: neuen Datentyp
}

export interface OrderState {
    appState: OrderAppState;
}

export const initialState: OrderState = {
    appState: {
        order: {}
    }
};
