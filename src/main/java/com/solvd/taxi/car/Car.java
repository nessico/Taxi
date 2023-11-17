package com.solvd.taxi.car;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Car extends Vehicle {
    Logger LOGGER = LogManager.getLogger(Car.class);

    public Car() {
    }

    public Car(String plate, String make, String model, int year) {
        super(plate, make, model, year);
    }

    @Override
    public void start() {
        LOGGER.info("Car starting up");
    }

    @Override
    public void stop() {
        LOGGER.info("Car stopping");
    }
}