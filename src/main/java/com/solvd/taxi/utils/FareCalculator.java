package com.solvd.taxi.utils;

@FunctionalInterface
public interface FareCalculator {

    double calculateFare(double fare, double multiplier);
}
