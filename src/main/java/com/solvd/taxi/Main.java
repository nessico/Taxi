package com.solvd.taxi;


import  com.solvd.taxi.car.Ride;
import  com.solvd.taxi.car.Car;
import  com.solvd.taxi.car.Vehicle;
import  com.solvd.taxi.human.*;
import com.solvd.taxi.utils.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import com.solvd.taxi.human.Driver;
import java.lang.reflect.Constructor;


public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {



        // Core logic of app

        // Create Test Passenger, Driver, and Vehicle

        Rating gabeRating = new Rating();
        gabeRating.addRating(5, "Default Passenger 5 star");
        Passenger gabe = new Passenger(1, "Gabe Newell", "1234567890 ", gabeRating);

        LOGGER.info(gabe.getName() + " has a rating of " +  gabe.getRating().getRatingValue(0) + " stars.");

        Car johnCar = new Car("CALI213", "Toyota", "Camry", 2015);

        ServiceArea johnServiceArea = new ServiceArea("San Diego", "CA");

        Rating johnRating = new Rating();
        johnRating.addRating(5, "Default Driver 5 star");
        Driver john = new Driver(1, "John", "12451511", johnCar, johnRating, 75000, johnServiceArea);

        LOGGER.info(john.getName() + " has a rating of " + john.getRating().getRatingValue(0) + " stars.");

        LOGGER.info("John drives a " + johnCar.toString());

        LOGGER.info("John's service area is " + johnServiceArea.getCityAndState());

        LOGGER.info("----");

        // Create info for ride

        Location pickup = new Location("5532 Spring Valley", "San Diego", "CA");
        Location dropoff = new Location("1234 Main St", "San Diego", "CA");

        if (pickup.getCityAndState().equals(johnServiceArea.getCityAndState())) {
            LOGGER.info("John services this area and can pick up Gabe.");
        } else {
            LOGGER.info("John cannot pick up the passenger.");
        }

        Fare fare = new Fare();
        fare.calculateTotalCost();


        LOGGER.info("The total cost of the ride is $" + fare.getTotalCost());

        CreditCardPayment creditCardPayment = new CreditCardPayment(fare.getTotalCost(), "USD", "Visa", "Pending", "ride for gabe by john");

        LOGGER.info("Gabe made the following payment: " + creditCardPayment.toString());

        // Booking ride
        Booking booking = new Booking(1, gabe, pickup, dropoff, false);

        // During Ride
        Rating rideRating = new Rating();
        rideRating.addRating(4, "Polite driver, but he's kind of fast");
        Ride ride = new Ride(111, fare, rideRating, johnCar);
        ride.addCostService();

        // End ride


        // Ride is completed

        LOGGER.info("----");



        LOGGER.info("The ride id is " + ride.getId() + " and it was a "+  ride.getRating().getRatingValue(0)  + " star ride.");



        LOGGER.info("----");
        printRole(john);
        printRole(gabe);


        // Testing queue generic


        LOGGER.info("----");

        // Can have a queue of driver, passenger later, so they are assigned by order of when they requested a ride
        Rating bobRating = new Rating();
        bobRating.addRating(5, "Default Passenger 5 star");
        Passenger bob = new Passenger(2, "Bob", "1112320150 ", bobRating);
        Queue<Passenger> passengerQueue = new Queue<>();
        passengerQueue.enqueue(bob);
        LOGGER.info("Passenger succesfully enqued to queue: "+ bob.getName());

        Booking booking3 = new Booking(3, passengerQueue.dequeue(), pickup, dropoff, false);
        LOGGER.info("Passenger succesfully dequeud to booking: "+ booking3.getPassenger().getName());

        // Test if finding driver works
        LOGGER.info("Driver found by id: " + john.findDriverById(1).getName());

        // Lambda test
        Fare rideFare = new Fare(100.0); // Example fare
        Ride rideLambdaTest = new Ride(111, rideFare, rideRating, johnCar);
        double fareTest = rideLambdaTest.calculateFare((baseFare, multiplier) -> baseFare * multiplier);
        LOGGER.info("Fare calculated with lambda: " + fareTest);


        // Reflection integration
        Main mainApp = new Main();
        Driver dynamicDriver = mainApp.createDriverDynamically();

        if (dynamicDriver != null) {
            // Create a Ride object
            Fare dynamicFare = new Fare();
            Rating rating = new Rating();
            Car car = new Car();
            Ride dynamicRide = new Ride(552, dynamicFare, rating, car);

            // Assign the driver to the ride
            dynamicRide.assignDriverToRide(dynamicDriver, dynamicRide);

            LOGGER.info("Dynamic Driver assigned to ride: " + dynamicRide.getCurrentRide(dynamicDriver).getId());
        }


    }

    // abstract polymorphism
    public static void test(Vehicle vehicle) {
        vehicle.start();
    }

    public static void printRole(Human human) {
        LOGGER.info(human.getRole());
    }

    // Reflection method
    public Driver createDriverDynamically() {
        try {
            Class<?> driverClass = Class.forName("com.solvd.taxi.human.Driver");
            Constructor<?> constructor = driverClass.getConstructor();

            // Cast to Driver
            Driver driver = (Driver) constructor.newInstance();

            // Putting data in reflection
            driver.setName("John Doe");
            driver.setPhone("1234567890");

            return driver;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }





}