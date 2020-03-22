import { Product } from 'src/api/model/product';

export interface OrderAppState {
    products: Product[];
}

export interface OrderState {
    appState: OrderAppState;
}

export const initialState: OrderState = {
    appState: {
        products: []
    }
};
