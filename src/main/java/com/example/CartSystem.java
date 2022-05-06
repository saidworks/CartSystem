package com.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class CartSystem extends TheSystem {
    CartSystem() throws IOException {
    }

    @Override
    public void display() {
        // Your code here
        // Your code here
    	Iterator <Map.Entry<String, Item>>  items = this.getItemCollection().entrySet().iterator();
    	double sub_total,tax,total;
		System.out.println("AppSystem Inventory");
		System.out.printf("%-20s %-20s %-10s %10s","Name","Description","Price","Quantity","Sub Total");
		System.out.println();
    	while(items.hasNext()) {
    		Item current = items.next().getValue();
    		sub_total = current.getQuantity() * current.getItemPrice();
    		tax = sub_total * 0.05;
    		total = sub_total + tax;
    		System.out.printf("%-20s %-20s %-10.2f %10d %-10.2f",current.getItemName(),current.getItemDesc(),current.getItemPrice(),current.getQuantity(),sub_total);
    		System.out.println();
    	}
    }

public static void main(String[] args) throws IOException {
	CartSystem c = new CartSystem();
	Iterator <Map.Entry<String, Item>>  items = c.getItemCollection().entrySet().iterator();
	double sub_total,tax,total;
	System.out.println("AppSystem Inventory");
	System.out.printf("%-20s %-20s %-10s %10s %-10s","Name","Description","Price","Quantity","Sub Total");
	System.out.println();
	while(items.hasNext()) {
		Item current = items.next().getValue();
		sub_total = current.getQuantity() * current.getItemPrice();
		tax = sub_total * 0.05;
		total = sub_total + tax;
		System.out.printf("%-20s %-20s %-10.2f %10d %-10.2f",current.getItemName(),current.getItemDesc(),current.getItemPrice(),current.getQuantity(),sub_total);
		System.out.println();
	}
}
}
