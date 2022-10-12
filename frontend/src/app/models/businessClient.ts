import { PaymentMethod } from "../enums/payment-method";

export interface BusinessClient {
  id: number,
  companyName: string,
  registerCode: number,
  participantQuantity: number,
  paymentMethod: PaymentMethod,
  additionalInfo: string
}
