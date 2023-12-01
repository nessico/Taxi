package com.solvd.taxi.car;

import com.solvd.taxi.exceptions.InvalidRideTypeException;
import com.solvd.taxi.exceptions.RideNotFoundException;
import com.solvd.taxi.human.Driver;
import com.solvd.taxi.human.Location;
import com.solvd.taxi.human.Passenger;
import com.solvd.taxi.utils.Fare;
import com.solvd.taxi.human.Rating;
import com.solvd.taxi.utils.FareCalculator;
import com.solvd.taxi.utils.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class Ride extends RideType {
    private static final Logger LOGGER = LogManager.getLogger(Ride.class);

    // Assign Driver to Ride
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
    public void checkRideType() {
        Vehicle vehicle = this.getVehicle();
        if (vehicle == null) {
            LOGGER.error("Invalid Car Ride type");
            throw new InvalidRideTypeException("Invalid Car Ride type");
        }
        LOGGER.info("You have a ride in vehicle type: " + vehicle.toString());
    }

    @Override
    public void checkIfRideExist() {
        int rideID = this.getId();
        // Assuming rideID should be a positive number
        if (rideID <= 0) {
            LOGGER.error("Ride does not exist");
            throw new RideNotFoundException("Ride does not exist");
        }
        LOGGER.info("Ride exists with ID: " + rideID);
    }



    // So we know which driver did what ride
    @Override
    public void assignDriverToRide(Driver driver, Ride ride) {
        Map<Driver, Ride> driverRideMap = this.getDriverRideMap();
        driverRideMap.put(driver, ride);

    }

    @Override
    public Ride getCurrentRide(Driver driver) {
        Map<Driver, Ride> driverRideMap = this.getDriverRideMap();
        return driverRideMap.get(driver);

    }

    public Response<Ride> bookRide(int id, Fare fare, Rating rating, Car car) {
        Ride ride = new Ride(id, fare, rating, car);
        return new Response<>(ride, "Ride booked successfully", true);
    }

    public double calculateFare(FareCalculator calculator) {
        return calculator.calculateFare(this.getFare().getFare(), 1.5);
    }


}



