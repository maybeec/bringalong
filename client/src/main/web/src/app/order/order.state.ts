import { Order, User } from 'src/api';


export interface OrderAppState {
    order: Order;
    user: User;
}

export interface OrderState {
    appState: OrderAppState;
}

export const initialState: OrderState = {
    appState: {
        order: {},
        user: {}
    }
};
