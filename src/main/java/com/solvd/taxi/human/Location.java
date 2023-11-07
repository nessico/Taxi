package com.solvd.taxi.human;

public class Location {

    private String address;
    private String city;
    private String state;

    public Location() {
    }

    public Location(String city, String state) {
        this.city = city;
        this.state = state;
    }

    public Location(String address, String city, String state) {
        this.address = address;
        this.city = city;
        this.state = state;

    }


    // getters
    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getState() {
        return this.state;
    }


    // setters

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCityAndState() {
        return getCity() + ", " + getState();
    }

}