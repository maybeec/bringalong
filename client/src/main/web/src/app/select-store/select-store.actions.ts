import { createAction, props } from '@ngrx/store';
import { Store, SearchStoresResult } from 'src/api';

export const searchForPlz = createAction('[Select Store Component] Search for PLZ', props<{plz: string }>());
export const searchForPlzSuccess = createAction('[Select Store Component] Search for PLZ Success', props<SearchStoresResult>());
export const searchForPlzError = createAction('[Select Store Component] Search for PLZ Error');

