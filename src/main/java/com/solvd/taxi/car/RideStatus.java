package com.solvd.taxi.car;

public enum RideStatus {
    WAITING("Waiting", "The ride is currently awaiting a driver"),
    ACCEPTED("Accepted", "The ride has been accepted by a driver"),
    ARRIVED("Arrived", "The driver has arrived at the pickup location"),
    IN_PROGRESS("In Progress", "The ride is currently in progress"),
    COMPLETED("Completed", "The ride has been completed"),
    CANCELLED_BY_DRIVER("Cancelled by Driver", "The ride has been cancelled by the driver"),
    CANCELLED_BY_RIDER("Cancelled by Rider", "The ride has been cancelled by the rider"),
    NO_SHOW("No Show", "The rider did not show up");

    private final String displayName;
    private final String description;

    RideStatus(String displayName, String description) {
        this.displayName = displayName;
        this.description = description;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return displayName + " - " + description;
    }
}
