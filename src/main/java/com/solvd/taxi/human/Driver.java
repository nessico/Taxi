package com.solvd.taxi.human;

import com.solvd.taxi.car.Car;
import com.solvd.taxi.utils.ServiceArea;

public class Driver extends Human {
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
        System.out.println("Picking up passenger");
    }

    @Override
    public String getRole() {
        return "I am a driver";
    }

}
