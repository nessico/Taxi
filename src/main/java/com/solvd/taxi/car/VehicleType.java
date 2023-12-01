package com.solvd.taxi.car;

public enum VehicleType {
    SEDAN(4, "Sedan", "Has enough space for 4 passengers"),
    SUV(6, "SUV", "Has enough space for 6"),
    MINIVAN(7, "Minivan", "Has enough space for 8 passengers"),
    LUXURY(4, "Luxury", "High-end space for 4 passenger"),
    ELECTRIC(4, "Electric", "For eco-friendly minded passengers, up to 4 space");

    private final int seats;
    private final String displayName;
    private final String description;

    VehicleType(int seats, String displayName, String description) {
        this.seats = seats;
        this.displayName = displayName;
        this.description = description;
    }

    public int getSeats() {
        return seats;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return displayName + " (" + description + ")";
    }
}
