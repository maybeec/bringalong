export interface RegisterAppState {
    coordinates: {
        lat: number,
        lng: number
    };
}

export interface RegisterState {
    appState: RegisterAppState;
}

export const initialState: RegisterState = {
    appState: {
        coordinates: undefined
    }
};