package com.solvd.taxi.human;

import com.solvd.taxi.car.Car;
import com.solvd.taxi.exceptions.DriverNotFoundException;
import com.solvd.taxi.utils.ServiceArea;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Driver extends Human {

    private static final Logger LOGGER = LogManager.getLogger(Driver.class);
    // Taxi driver

    private int id;

    private Car car;

    private float salary;

    private ServiceArea serviceArea;

    public Driver() {
    }

    public Driver(int id, String name, String phone, Car car, Rating rating, float salary, ServiceArea serviceArea) {
        super(name, phone, rating);
        this.id = id;
        this.car = car;
        this.salary = salary;
        this.serviceArea = serviceArea;
    }

    // getters

    public int getId() {
        return id;
    }

    public Car getVehicle() {
        return car;
    }


    public float getSalary() {
        return salary;
    }

    public ServiceArea getServiceArea() {
        return serviceArea;
    }

    // setters

    public void setId(int id) {
        this.id = id;
    }


    public void setVehicle(Car car) {
        this.car = car;
    }


    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setServiceArea(ServiceArea serviceArea) {
        this.serviceArea = serviceArea;
    }

    @Override
    public void message() {
        LOGGER.info("Picking up passenger");
    }

    @Override
    public String getRole() {
        return "I am a driver";
    }

    public Driver findDriverById(int id) throws DriverNotFoundException {
        Driver driver = getId() == id ? this : null;
        if (driver == null) {
            LOGGER.warn("Driver with ID not found");
            throw new DriverNotFoundException("Driver with ID not found");
        }
        return driver;
    }

}
