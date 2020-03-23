import { StoreOrder } from 'src/api';

export interface AcceptedOrdersAppState {
    orders: StoreOrder[]; // TODO: neuen Datentyp
}

export interface AcceptedOrdersState {
    appState: AcceptedOrdersAppState;
}

export const initialState: AcceptedOrdersState = {
    appState: {
        orders: []
    }
};
