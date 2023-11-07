package com.solvd.taxi.utils;

public class PayPalPayment extends PaymentType {

    public PayPalPayment() {
        super();
    }

    public PayPalPayment(double amount, String currency, String method, String status, String description) {
        super(amount, currency, method, status, description);
    }


    // $1 fee for paypal
    @Override
    public void processPayment() {
        double fee = 1.0;
        setAmount(getAmount() + 1);
    }

    @Override
    public String toString() {
        return null;
    }
}