package com.solvd.taxi.utils;

import com.solvd.taxi.human.Location;
import com.solvd.taxi.human.Passenger;

public abstract class BookingType {

    private int id;
    private Passenger passenger;
    private Location startLocation;
    private Location endLocation;
    private boolean isCompleted;

    public BookingType() {
    }

    public BookingType(int id, Passenger passenger, Location startLocation, Location endLocation, boolean isCompleted) {
        this.id = id;
        this.passenger = passenger;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.isCompleted = isCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public abstract void confirmBooking();

}
