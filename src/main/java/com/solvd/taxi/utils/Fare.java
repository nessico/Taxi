package com.solvd.taxi.utils;

public class Fare {
    // fare details

    private double fare;
    private double distance;
    private double time;
    private double totalCost;

    public Fare() {
    }

    public Fare(double fare, double distance, double time) {
        this.fare = fare;
        this.distance = distance;
        this.time = time;
    }

    // getters
    public double getFare() {
        return fare;
    }

    public double getDistance() {
        return distance;
    }

    public double getTime() {
        return time;
    }

    // setters

    public void setFare(double fare) {
        this.fare = fare;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setTime(double time) {
        this.time = time;
    }

    // placeholder because we can't actually calculate without maps API, longitude and latitude
    public void calculateTotalCost() {
        this.totalCost = 500;
    }

    public double getTotalCost() {
        return this.totalCost;
    }

    public void addCostService(int cost) {
        this.totalCost += cost;
    }


}