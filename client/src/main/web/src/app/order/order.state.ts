import { PageBringDemandEto } from 'src/api/model/pageBringDemandEto';

export interface OrderAppState {
    order: PageBringDemandEto;
}

export interface OrderState {
    appState: OrderAppState;
}

export const initialState: OrderState = {
    appState: {
        order: {}
    }
};
