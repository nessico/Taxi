package com.solvd.taxi.human;

import com.solvd.taxi.interfaces.IRating;

import java.util.List;

public class Rating implements IRating {

    private int rating;
    private String comment;

    public Rating() {
    }

    public Rating(int rating) {
        this.rating = rating;
    }

    public Rating(int rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }

    // getters
    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    // setters

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public double calculateAverageRating(int id) {
        return 0;
    }


}