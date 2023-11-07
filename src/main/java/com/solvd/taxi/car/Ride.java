package com.solvd.taxi.car;

import com.solvd.taxi.utils.Fare;
import com.solvd.taxi.human.Rating;

public class Ride extends RideType {

    public Ride() {
    }

    public Ride(int id, Fare fare, Rating rating, Car car) {

        super(id, fare, rating, car);
    }


    // set this as economy fare for testing
    @Override
    public void addCostService() {
        this.getFare().addCostService(10);
    }
}



