package com.solvd.taxi.utils;

public enum PaymentMethod {
    CASH("Cash", false, "Direct cash payment"),
    CREDIT_CARD("Credit Card", true, "Payment via credit card"),
    PAYPAL("PayPal", true, "Online payment via PayPal"),
    APPLE_PAY("Apple Pay", true, "Payment through Apple Pay on iOS devices"),
    GOOGLE_PAY("Google Pay", true, "Payment through Google Pay on Android devices");

    private final String displayName;
    private final boolean supportsOnlineTransaction;
    private final String description;

    PaymentMethod(String displayName, boolean supportsOnlineTransaction, String description) {
        this.displayName = displayName;
        this.supportsOnlineTransaction = supportsOnlineTransaction;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public boolean supportsOnlineTransaction() {
        return supportsOnlineTransaction;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return displayName + " - " + description;
    }
}
