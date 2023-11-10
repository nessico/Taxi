package com.solvd.taxi.utils;

import com.solvd.taxi.exceptions.PaymentProcessingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PayPalPayment extends PaymentType {
    private static final Logger LOGGER = LogManager.getLogger(PayPalPayment.class);

    public PayPalPayment() {
        super();
    }

    public PayPalPayment(double amount, String currency, String method, String status, String description) {
        super(amount, currency, method, status, description);
    }


    // $1 fee for paypal
    @Override
    public void processPayment() throws PaymentProcessingException {
        try {
            double fee = 1.0;
            setAmount(getAmount() + 2);
            LOGGER.info("Processed $1 paypal fee");
        } catch (Exception e) {
            LOGGER.error("Error processing payment");
            throw new PaymentProcessingException("Error processing payment");
        }
    }

    @Override
    public String toString() {
        return null;
    }


}