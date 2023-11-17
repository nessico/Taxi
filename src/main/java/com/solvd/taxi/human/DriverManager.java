package com.solvd.taxi.human;

import com.solvd.taxi.exceptions.DriverNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class DriverManager {

    // To manage all Driver Ids for later implementation
    private Set<Driver> drivers;

    public DriverManager() {
        drivers = new HashSet<>();
    }

    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    public Driver findDriverById(int id)  {
        return drivers.stream()
                .filter(driver -> driver.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DriverNotFoundException("Driver with ID not found"));
    }
}