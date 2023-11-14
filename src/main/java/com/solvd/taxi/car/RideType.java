package com.solvd.taxi.car;

import com.solvd.taxi.human.*;
import com.solvd.taxi.interfaces.ITaxiService;
import com.solvd.taxi.utils.Fare;

import java.util.HashMap;
import java.util.Map;


public abstract class RideType implements ITaxiService {

    private int id;
    private Driver driver;
    private Human human;
    private Location startLocation;
    private Location endLocation;
    private Fare fare;
    private Rating rating;
    private Car car;
    private final Map<Driver, Ride> driverRideMap;

    public RideType() {
        driverRideMap = new HashMap<>();
    }

    public RideType(int id, Fare fare, Rating rating, Car car) {
        this.id = id;
        this.fare = fare;
        this.rating = rating;
        this.car = car;
        driverRideMap = new HashMap<>();
    }

    // getters

    public int getId() {
        return id;
    }

    public Fare getFare() {
        return fare;
    }

    public Rating getRating() {
        return rating;
    }

    public Car getVehicle() {
        return car;
    }


    // setters

    public void setId(int id) {
        this.id = id;
    }

    public void setFare(Fare fare) {
        this.fare = fare;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setVehicle(Car car) {
        this.car = car;
    }

    public Map<Driver, Ride> getDriverRideMap() {
        return driverRideMap;
    }

    public void setDriverRideMap(Driver driver, Ride ride) {
        driverRideMap.put(driver, ride);
    }

    @Override
    public abstract void addCostService();

    @Override
    public abstract void checkRideType() throws Exception;

    @Override
    public abstract void checkIfRideExist() throws Exception;

    @Override
    public abstract void assignDriverToRide(Driver driver, Ride ride);


    @Override
    public abstract Ride getCurrentRide(Driver driver);



}