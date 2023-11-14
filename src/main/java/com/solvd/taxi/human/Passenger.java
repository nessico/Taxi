package com.solvd.taxi.human;

import com.solvd.taxi.exceptions.DriverNotFoundException;
import com.solvd.taxi.exceptions.PassengerNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Passenger extends Human {

    private static final Logger LOGGER = LogManager.getLogger(Passenger.class);

    private int id;


    public Passenger() {
    }

    public Passenger(int id, String name, String phone, Rating rating) {
        super(name,phone, rating);
        this.id = id;
    }



    public int getId() {
        return id;
    }




    public void setId(int id) {
        this.id = id;
    }



    @Override
    public void message() {
        LOGGER.info("Getting in Car");
    }

    @Override
    public String getRole() {
        return "I am a passenger";
    }

    public Passenger findPassengerById(int id) throws PassengerNotFoundException {
        Passenger passenger = getId() == id ? this : null;
        if (passenger == null) {
            LOGGER.warn("Driver with ID not found");
            throw new PassengerNotFoundException("Passenger with ID not found");
        }
        return passenger;
    }

}