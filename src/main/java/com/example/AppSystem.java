package com.example;

import java.io.IOException;

public class AppSystem extends TheSystem {
    AppSystem() throws IOException {
    }

    @Override
    public void display() {
        // Your code here
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
        // Your code here
    }

    public Item reduceAvailableQuantity(String item_name) {
        // Your code here
    }
}
