/**
 * bringalong
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 1.0.0
 * Contact: todo@test.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */
import { OrderItem } from './orderItem';


export interface OwnOrder { 
    id?: number;
    storeId?: number;
    startDate?: string;
    startTime?: string;
    endDate?: string;
    endTime?: string;
    orderItems?: Array<OrderItem>;
}
