import { UserOrder } from 'src/api';

export interface OrdersAppState {
    orders: UserOrder[];
}

export interface OrdersState {
    appState: OrdersAppState;
}

export const initialState: OrdersState = {
    appState: {
        orders: undefined
    }
};
