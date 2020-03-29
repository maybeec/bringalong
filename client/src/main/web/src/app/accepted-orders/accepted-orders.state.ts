import { UserOrder } from 'src/api';

export interface AcceptedOrdersAppState {
    orders: UserOrder[];
}

export interface AcceptedOrdersState {
    appState: AcceptedOrdersAppState;
}

export const initialState: AcceptedOrdersState = {
    appState: {
        orders: []
    }
};
