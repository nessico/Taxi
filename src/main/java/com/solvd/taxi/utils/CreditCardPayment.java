package com.solvd.taxi.utils;

import com.solvd.taxi.exceptions.PaymentProcessingException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreditCardPayment extends PaymentType {
    private static final Logger LOGGER = LogManager.getLogger(CreditCardPayment.class);

    public CreditCardPayment() {
        super();
    }

    public CreditCardPayment(double amount, String currency, String method, String status, String description) {
        super(amount, currency, method, status, description);
    }


    // $2 fee for credit card
    @Override
    public void processPayment()  {
        try {
            double fee = 2.0;
            setAmount(getAmount() + 2);
            LOGGER.info("Processed $2 credit card fee");
        } catch (Exception e) {
            LOGGER.error("Error processing payment");
            throw new PaymentProcessingException("Error processing payment");
        }
    }


    @Override
    public String toString() {
        return "amount = " + getAmount() + ", currency = " + getCurrency() + ", method = " + getMethod() + ", status = " + getStatus() + ", description = " + getDescription();
    }
}