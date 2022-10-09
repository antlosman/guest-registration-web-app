package com.guestregistration.guestregistrationwebapp.enumeration;

public enum PaymentMethod {

    CASH("CASH"),
    CARD("CARD");

    private final String paymentMethod;

    PaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }
}
