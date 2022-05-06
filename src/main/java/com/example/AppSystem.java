package com.example;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class AppSystem extends TheSystem {
    AppSystem() throws IOException {
    }

    @Override
    public void display() {
        // Your code here
    	Iterator <Map.Entry<String, Item>>  items = this.getItemCollection().entrySet().iterator();
		System.out.println("AppSystem Inventory");
		System.out.printf("%-20s %-20s %-10s %10s","Name","Description","Price","Availability");
		System.out.println();
    	while(items.hasNext()) {
    		Item current = items.next().getValue();
    		System.out.printf("%-20s %-20s %-10.2f %10d",current.getItemName(),current.getItemDesc(),current.getItemPrice(),current.getAvailableQuantity());
    		System.out.println();
	}
    }

    @Override      // this overwrites the parents class add method 
    public Boolean add(Item item) {
		if(item == null) {
			return false;
		}
		else if(this.getItemCollection().containsValue(item)) {
			System.out.println(item.getItemName()+ " is already in the App System");
			return false;
		}
		//item not in the collection 
		else {
			this.getItemCollection().put(item.getItemName(), item);
			return true;
		}
        // Your code here
    }

    public Item reduceAvailableQuantity(String item_name) {
    	if(this.getItemCollection().containsKey(item_name)) {
    		int quantity = this.getItemCollection().get(item_name).getAvailableQuantity();
    		this.getItemCollection().get(item_name).setAvailableQuantity(quantity-1);
    		return this.getItemCollection().get(item_name);
    	}
    	else{
    		return null;
    		}
        // Your code here
    }
    
//    public static void main(String[] args) throws IOException {
//		AppSystem a = new AppSystem();
//		System.out.println("AppSystem Inventory");
//		System.out.printf("%-20s %-20s %-10s %10s","Name","Description","Price","Availability");
//		System.out.println();
//    	Iterator <Map.Entry<String, Item>>  items = a.getItemCollection().entrySet().iterator();
//    	while(items.hasNext()) {
//    		Item current = items.next().getValue();
//    		System.out.printf("%-20s %-20s %-10.2f %10d",current.getItemName(),current.getItemDesc(),current.getItemPrice(),current.getAvailableQuantity());
//    		System.out.println();
//	}
//    }
}
