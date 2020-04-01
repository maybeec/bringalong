import { createAction, props } from '@ngrx/store';
import { RegisterRequest, RegisterResponse } from 'src/api';

export const register = createAction('[Register Component] register', props<RegisterRequest>());
export const registerSuccess = createAction('[Register Component] register Success', props<RegisterResponse>());
export const registerError = createAction('[Register Component] register Error');


export interface GetLatLongRequest {
    location: string;
}

export interface GetLatLongResponse {
    results: [
        {
            locations: [
                {
                    latLng: {
                        lat: number,
                        lng: number
                    }
                }
            ]
        }
    ];
}

export const getLatLong = createAction('[Register Component] getLatLong', props<GetLatLongRequest>());
export const getLatLongSuccess = createAction('[Register Component] getLatLong Success', props<GetLatLongResponse>());
export const getLatLongError = createAction('[Register Component] getLatLong Error');
