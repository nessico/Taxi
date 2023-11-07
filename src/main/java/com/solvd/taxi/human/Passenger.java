package com.solvd.taxi.human;

public class Passenger extends Human {

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
        System.out.println("Getting in car");
    }

    @Override
    public String getRole() {
        return "I am a passenger";
    }

}