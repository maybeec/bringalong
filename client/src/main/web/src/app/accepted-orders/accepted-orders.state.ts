import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export interface AcceptedOrdersAppState {
    orders: PageBringDemandEto[];
}

export interface AcceptedOrdersState {
    appState: AcceptedOrdersAppState;
}

export const initialState: AcceptedOrdersState = {
    appState: {
        orders: []
    }
};
