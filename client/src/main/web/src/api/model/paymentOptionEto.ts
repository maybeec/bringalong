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


export interface PaymentOptionEto { 
    id?: number;
    modificationCounter?: number;
    type?: PaymentOptionEto.TypeEnum;
    reference?: string;
}
export namespace PaymentOptionEto {
    export type TypeEnum = 'PAYPAL' | 'SEPA' | 'PAYPALME';
    export const TypeEnum = {
        PAYPAL: 'PAYPAL' as TypeEnum,
        SEPA: 'SEPA' as TypeEnum,
        PAYPALME: 'PAYPALME' as TypeEnum
    };
}
