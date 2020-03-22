import { createReducer, on } from '@ngrx/store';
import { initialState } from './app.state';
import { createOrderSuccess, createOrderError, getProductsForStoreError } from './order/order.actions';
import { getOrdersError, bringOrderError } from './store-orders/store-orders.actions';
import { searchForPlzError } from './select-store/select-store.actions';

const genericErrorMessage = 'Es ist ein Fehler aufgetreten. Bitte versuchen Sie es erneut.';
function setGenericErrorMessage(state) {
    return { ...state,
        uiState: {
            ...state.uiState,
            message: genericErrorMessage
        }
    };
}

const appReducerCreator = createReducer(initialState,
    on(createOrderError, setGenericErrorMessage),
    on(getOrdersError, setGenericErrorMessage),
    on(getProductsForStoreError, setGenericErrorMessage),
    on(searchForPlzError, setGenericErrorMessage),
    on(bringOrderError, setGenericErrorMessage)
);

export function appReducer(state, action) {
    return appReducerCreator(state, action);
}
