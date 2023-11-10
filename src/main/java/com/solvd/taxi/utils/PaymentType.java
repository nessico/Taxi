package com.solvd.taxi.utils;

import com.solvd.taxi.exceptions.PaymentProcessingException;
import com.solvd.taxi.interfaces.IPaymentProcessor;

public abstract class PaymentType implements IPaymentProcessor {
    private double amount;
    private String currency;
    private String method;
    private String status;
    private String description;

    public PaymentType() {
    }

    public PaymentType(double amount, String currency, String method, String status, String description) {
        this.amount = amount;
        this.currency = currency;
        this.method = method;
        this.status = status;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract void processPayment() throws PaymentProcessingException;

    public abstract String toString();
}