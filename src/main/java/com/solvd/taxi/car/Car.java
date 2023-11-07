package com.solvd.taxi.car;

public class Car extends Vehicle {

    public Car() {
    }

    public Car(String plate, String make, String model, int year) {
        super(plate, make, model, year);
    }

    @Override
    public void start() {
        System.out.println("Car starting up");
    }

    @Override
    public void stop() {
        System.out.println("Car stopping");
    }
}