import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export interface OrdersAppState {
    orders: PageBringDemandEto[];
}

export interface OrdersState {
    appState: OrdersAppState;
}

export const initialState: OrdersState = {
    appState: {
        orders: []
    }
};
