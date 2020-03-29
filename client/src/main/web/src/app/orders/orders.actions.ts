import { createAction, props } from '@ngrx/store';
import { GetOrdersByLatLongResponse } from 'src/api';

export const getOrdersByLatLong = createAction('[Orders Component] getOrdersByLatLong', props<{lat: number, long: number}>());
export const getOrdersByLatLongSuccess = createAction('[Orders Component] getOrdersByLatLong Success',
                                            props<GetOrdersByLatLongResponse>());
export const getOrdersByLatLongError = createAction('[Orders Component] getOrdersByLatLong Error');
