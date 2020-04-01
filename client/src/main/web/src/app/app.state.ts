import { OrdersState } from './orders/orders.state';
import { MyOrdersState } from './my-orders/my-orders.state';
import { OrderState } from './order/order.state';
import { AcceptedOrdersState } from './accepted-orders/accepted-orders.state';
import { EditOrderState } from './edit-order/edit-order.state';
import { User } from 'src/api';
import { RegisterState } from './register/register.state';

export interface ApplicationUiState {
    message: string;
}

export interface ApplicationAppState {
    loggedIn: boolean;
    user?: User;
}

export interface ApplicationState {
    uiState: ApplicationUiState;
    appState: ApplicationAppState;
}

export interface AppState {
    app?: ApplicationState;
    orders?: OrdersState;
    myOrders?: MyOrdersState;
    order?: OrderState;
    acceptedOrders?: AcceptedOrdersState;
    editOrder?: EditOrderState;
    register?: RegisterState;
}

export const initialState: ApplicationState = {
    uiState: {
        message: ''
    },
    appState: {
        loggedIn: undefined
    }
};
