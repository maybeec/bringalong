import { SelectStoreState } from './select-store/select-store.state';
import { StoreOrdersState } from './store-orders/store-orders.state';
import { OrderState } from './order/order.state';

export interface ApplicationUiState {
    message: string;
}

export interface ApplicationState {
    uiState: ApplicationUiState;
}

export interface AppState {
    selectStore?: SelectStoreState;
    storeOrders?: StoreOrdersState;
    order?: OrderState;
    app?: ApplicationState;
}

export const initialState: ApplicationState = {
    uiState: {
        message: ''
    }
};
