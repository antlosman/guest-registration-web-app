import { PaymentMethod } from "../enums/payment-method";

export interface PrivateClient {
  id: number,
  firstName: string,
  lastName: string,
  idNumber: number,
  paymentMethod: PaymentMethod,
  additionalInfo: string
}
