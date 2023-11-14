package com.solvd.taxi.human;

import com.solvd.taxi.interfaces.IRating;
import java.util.ArrayList;
import java.util.List;

public class Rating implements IRating {
    private List<Pair> ratings;

    public class Pair {
        int rating;
        String comment;

        public Pair(int rating, String comment) {
            this.rating = rating;
            this.comment = comment;
        }

        // Pair Getters
        public int getRating() {
            return rating;
        }

        public String getComment() {
            return comment;
        }
    }

    public Rating() {
        ratings = new ArrayList<>();
    }



    public void addRating(int rating, String comment) {
        ratings.add(new Pair(rating, comment));
    }

    // Getters for the entire list or individual ratings
    public List<Pair> getRatings() {
        return new ArrayList<>(ratings);
    }

    public Pair getRating(int index) {
        if (index >= 0 && index < ratings.size()) {
            return ratings.get(index);
        }
        return null;
    }


    public int getRatingValue(int index) {
        if (index >= 0 && index < ratings.size()) {
            return ratings.get(index).rating;
        }
        return -1;
    }


    public String getComment(int index) {
        if (index >= 0 && index < ratings.size()) {
            return ratings.get(index).comment;
        }
        return "";
    }


    @Override
    public double calculateAverageRating(int id) {
        if (ratings.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (Pair rating : ratings) {
            sum += rating.getRating();
        }
        return sum / ratings.size();
    }
}
