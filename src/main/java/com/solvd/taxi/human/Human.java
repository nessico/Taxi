package com.solvd.taxi.human;

public abstract class Human {

    private String name;
    private String phone;

    private Rating rating;


    public Human() {
    }

    public Human(String name, String phone, Rating rating) {
        this.name = name;
        this.phone = phone;
        this.rating = rating;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Rating getRating() {
        return rating;
    }

    public String getPhone() {
        return phone;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public abstract void message();

    public abstract String getRole();
}