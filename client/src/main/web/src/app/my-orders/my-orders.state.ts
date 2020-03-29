import { UserOrder } from 'src/api';

export interface MyOrdersAppState {
    orders: UserOrder[];
}

export interface MyOrdersState {
    appState: MyOrdersAppState;
}

export const initialState: MyOrdersState = {
    appState: {
        orders: []
    }
};
