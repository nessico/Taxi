package com.solvd.taxi.utils;


import java.util.ArrayList;
import java.util.List;

public class Queue <T> {
    private List<T> elements;
    public Queue() {
        elements = new ArrayList<>();
    }
    public void enqueue(T element) {
        elements.add(element);
    }
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        return elements.remove(0);
    }
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
