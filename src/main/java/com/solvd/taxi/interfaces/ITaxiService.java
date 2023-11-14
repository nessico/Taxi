package com.solvd.taxi.interfaces;

import com.solvd.taxi.car.Ride;
import com.solvd.taxi.human.Driver;

public interface ITaxiService {

    void addCostService();

    void checkRideType() throws Exception;

    void checkIfRideExist() throws Exception;

    void assignDriverToRide(Driver driver, Ride ride);

     Ride getCurrentRide(Driver driver);



}