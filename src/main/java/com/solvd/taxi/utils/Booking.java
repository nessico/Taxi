package com.solvd.taxi.utils;

import com.solvd.taxi.human.Location;
import com.solvd.taxi.human.Passenger;

public class Booking extends BookingType {

    public Booking() {
    }

    public Booking(int id, Passenger passenger, Location startLocation, Location endLocation, boolean isCompleted) {
        super(id, passenger, startLocation, endLocation, isCompleted);
    }

    @Override
    public void confirmBooking() {
        // logic to confirm the booking
    }

}