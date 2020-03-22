import { StoreOrder } from 'src/api';



export interface StoreOrdersAppState {
    orders: StoreOrder[];
}

export interface StoreOrdersState {
    appState: StoreOrdersAppState;
}

export const initialState: StoreOrdersState = {
    appState: {
        orders: []
    }
};
