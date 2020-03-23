import { StoreOrder } from 'src/api';



export interface OrdersAppState {
    orders: StoreOrder[]; // TODO: neuen Datentyp
}

export interface OrdersState {
    appState: OrdersAppState;
}

export const initialState: OrdersState = {
    appState: {
        orders: []
    }
};
