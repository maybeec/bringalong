import { StoreOrder } from 'src/api';

export interface MyOrdersAppState {
    orders: StoreOrder[]; // TODO: neuen Datentyp
}

export interface MyOrdersState {
    appState: MyOrdersAppState;
}

export const initialState: MyOrdersState = {
    appState: {
        orders: []
    }
};
