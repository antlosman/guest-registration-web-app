import { PaymentMethod } from "../enums/payment-method";

export interface BusinessClient {
  id: number,
  companyName: string,
  registerCode: number,
  participantsQuantity: number,
  paymentMethod: PaymentMethod,
  additionalInfo: string
}
