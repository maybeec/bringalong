/**
 * BringAlong Server REST API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { Pageable } from './pageable';
import { Sort } from './sort';


export interface Page { 
    totalPages?: number;
    totalElements?: number;
    number?: number;
    size?: number;
    content?: Array<any>;
    sort?: Sort;
    first?: boolean;
    numberOfElements?: number;
    pageable?: Pageable;
    last?: boolean;
    empty?: boolean;
}
