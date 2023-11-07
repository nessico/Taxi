package com.solvd.taxi.car;
import com.solvd.taxi.car.Car;

public abstract class Vehicle {
    private String plate;
    private String make;
    private String model;
    private int year;

    public Vehicle() {}

    public Vehicle(String plate, String make, String model, int year) {
        this.plate = plate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters
    public String getPlate() {
        return plate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    // Setters
    public void setPlate(String plate) {
        this.plate = plate;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    // toString method, if all vehicles are represented in a similar way, otherwise, it should be abstract
    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }

    public abstract void start();

    public abstract void stop();

}