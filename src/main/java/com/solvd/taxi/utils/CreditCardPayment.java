package com.solvd.taxi.utils;

public class CreditCardPayment extends PaymentType {

    public CreditCardPayment() {
        super();
    }

    public CreditCardPayment(double amount, String currency, String method, String status, String description) {
        super(amount, currency, method, status, description);
    }


    // $2 fee for credit card
    @Override
    public void processPayment() {
        double fee = 2.0;
        setAmount(getAmount() + 2);
    }


    @Override
    public String toString() {
        return "amount = " + getAmount() + ", currency = " + getCurrency() + ", method = " + getMethod() + ", status = " + getStatus() + ", description = " + getDescription();
    }
}