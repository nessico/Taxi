package com.solvd.taxi.car;

import com.solvd.taxi.exceptions.InvalidRideTypeException;
import com.solvd.taxi.exceptions.RideNotFoundException;
import com.solvd.taxi.utils.Fare;
import com.solvd.taxi.human.Rating;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Ride extends RideType {
    private static final Logger LOGGER = LogManager.getLogger(Ride.class);
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

    @Override
    public void checkRideType() throws InvalidRideTypeException {
        try {
            Vehicle vehicle = this.getVehicle();
            LOGGER.info("You have a ride in vehicle type:  " + vehicle.toString());
        } catch (Exception e){
            LOGGER.error("Invalid Car Ride type");
            throw new InvalidRideTypeException("Invalid Car Ride type");
        }
    }

    @Override
    public void checkIfRideExist() throws RideNotFoundException {
        try {
            int rideID = this.getId();
            LOGGER.info("ride exists" + rideID);
        } catch (Exception e) {
            LOGGER.error("Ride does not exist");
            throw new RideNotFoundException("Ride does not exist");
        }
    }
}



