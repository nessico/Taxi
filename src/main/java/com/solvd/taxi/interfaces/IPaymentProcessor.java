package com.solvd.taxi.interfaces;

public interface IPaymentProcessor {

    // for credit card and paypal so far
    void processPayment() throws Exception;

}