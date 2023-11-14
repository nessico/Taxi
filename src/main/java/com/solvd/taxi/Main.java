package com.solvd.taxi;


import  com.solvd.taxi.car.Ride;
import  com.solvd.taxi.car.Car;
import  com.solvd.taxi.car.Vehicle;
import  com.solvd.taxi.human.*;
import  com.solvd.taxi.utils.Booking;
import  com.solvd.taxi.utils.Fare;
import  com.solvd.taxi.utils.CreditCardPayment;
import  com.solvd.taxi.utils.ServiceArea;

public class Main {
    public static void main(String[] args) {

        // Core logic of app

        // Create Test Passenger, Driver, and Vehicle

        Rating gabeRating = new Rating();
        gabeRating.addRating(5, "Default Passenger 5 star");
        Passenger gabe = new Passenger(1, "Gabe Newell", "1234567890 ", gabeRating);

        System.out.println(gabe.getName() + " has a rating of " +  gabe.getRating().getRatingValue(0) + " stars.");

        Car johnCar = new Car("CALI213", "Toyota", "Camry", 2015);

        ServiceArea johnServiceArea = new ServiceArea("San Diego", "CA");

        Rating johnRating = new Rating();
        johnRating.addRating(5, "Default Driver 5 star");
        Driver john = new Driver(1, "John", "12451511", johnCar, johnRating, 75000, johnServiceArea);

        System.out.println(john.getName() + " has a rating of " + john.getRating().getRatingValue(0) + " stars.");

        System.out.println("John drives a " + johnCar.toString());

        System.out.println("John's service area is " + johnServiceArea.getCityAndState());

        System.out.println("----");

        // Create info for ride

        Location pickup = new Location("5532 Spring Valley", "San Diego", "CA");
        Location dropoff = new Location("1234 Main St", "San Diego", "CA");

        if (pickup.getCityAndState().equals(johnServiceArea.getCityAndState())) {
            System.out.println("John services this area and can pick up Gabe.");
        } else {
            System.out.println("John cannot pick up the passenger.");
        }

        Fare fare = new Fare();
        fare.calculateTotalCost();


        System.out.println("The total cost of the ride is $" + fare.getTotalCost());

        CreditCardPayment creditCardPayment = new CreditCardPayment(fare.getTotalCost(), "USD", "Visa", "Pending", "ride for gabe by john");

        System.out.println("Gabe made the following payment: " + creditCardPayment.toString());

        // Booking ride
        Booking booking = new Booking(1, gabe, pickup, dropoff, false);

        // During Ride
        Rating rideRating = new Rating();
        rideRating.addRating(4, "Polite driver, but he's kind of fast");
        Ride ride = new Ride(111, fare, rideRating, johnCar);
        ride.addCostService();

        // End ride


        // Ride is completed

        System.out.println("----");



        System.out.println("The ride id is " + ride.getId() + " and it was a "+  ride.getRating().getRatingValue(0)  + " star ride.");



        System.out.println("----");
        printRole(john);
        printRole(gabe);


    }

    // abstract polymorphism
    public static void test(Vehicle vehicle) {
        vehicle.start();
    }

    public static void printRole(Human human) {
        System.out.println(human.getRole());
    }


    // testing message response



}