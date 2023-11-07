package com.solvd.taxi.car;

import com.solvd.taxi.human.*;
import com.solvd.taxi.interfaces.ITaxiService;
import com.solvd.taxi.utils.Fare;


public abstract class RideType implements ITaxiService {

    private int id;
    private Driver driver;
    private Human human;
    private Location startLocation;
    private Location endLocation;
    private Fare fare;
    private Rating rating;
    private Car car;

    public RideType() {
    }

    public RideType(int id, Fare fare, Rating rating, Car car) {
        this.id = id;
        this.fare = fare;
        this.rating = rating;
        this.car = car;
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

    @Override
    public abstract void addCostService();




}