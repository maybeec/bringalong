import { createAction, props } from '@ngrx/store';
import { LoadProductsForStoreResult } from 'src/api';

export const loadProductsForStore = createAction('[Order Component] loadOrders', props<{id: number }>());
export const loadProductsForStoreSuccess = createAction('[Order Component] loadOrders Success', props<LoadProductsForStoreResult>());
export const loadProductsForStoreError = createAction('[Order Component] loadOrders Error');

