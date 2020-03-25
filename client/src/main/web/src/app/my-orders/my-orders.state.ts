import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export interface MyOrdersAppState {
    orders: PageBringDemandEto[];
}

export interface MyOrdersState {
    appState: MyOrdersAppState;
}

export const initialState: MyOrdersState = {
    appState: {
        orders: []
    }
};
