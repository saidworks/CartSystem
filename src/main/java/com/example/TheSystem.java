package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;



public abstract class TheSystem {
	private HashMap<String, Item> itemCollection; 

    TheSystem() {
        // Your code here
    	this.itemCollection = new HashMap<String, Item>();
    	if(getClass().getSimpleName().equals("AppSystem")) {
    		try {
        		FileInputStream fileIn = new FileInputStream("resources/sample.txt");
    			BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));
    			  ArrayList<String[]> items =  new ArrayList<>();
    			  String[] itemInfo;
    			  String line;
    		      
    			  while ((line = br.readLine()) != null) {
    		          if(line.contains("NAME")) {
    		        	  continue;
    		          }
    		          else {
//    		        	  line = line.replaceAll("\\*", " ");
    		        	  itemInfo = line.split("\\s{2}");
    		        	  items.add(itemInfo);
    		          }
    		      }
    		     
    			  Iterator<String[]> elements = items.iterator();
    		      while(elements.hasNext()) {
    		    	  String[] current = elements.next();
    		    	  itemCollection.put(current[0], new Item(current[0],current[1],Double.parseDouble(current[2]),Integer.parseInt(current[3])));
    		      }
    		      
    		      fileIn.close();
    		  }
    		catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    }
    
    public HashMap<String, Item> getItemCollection(){
        return this.itemCollection;
    }
    
    public void setItemCollection(HashMap<String, Item> itemCollection) {
    	this.itemCollection = itemCollection;
    }
    
    public Boolean checkAvailability(Item item) {
		if(item.getQuantity()>item.getAvailableQuantity()) {
			System.out.println("System is unable to add [item name] to the card. System only has [item available quantity][item name]s");
			return false;
		}
    	return true;
        // Your code here
    }
    
    public Boolean add(Item item) {
    	if(item == null) {
    		return false;
    	}
    	else if(this.itemCollection.containsValue(item) && this.itemCollection.get(item.getItemName()).getAvailableQuantity()>0) {
    		item.setQuantity(item.getQuantity()+1);
    		return true;
    	}
    	else if(!this.itemCollection.containsValue(item)) {
    		this.itemCollection.put(item.getItemName(), item);
    		return true;
    	}
    	else {
		return false;}
        // Your code here
    }

    public Item remove(String itemName) {
		if(this.itemCollection.keySet().contains(itemName)) {
			this.itemCollection.remove(itemName);
			return this.itemCollection.get(itemName);
		}
		else {
			return null;
		}
        // Your code here
    }

    public abstract void display();
    
//    public static void main(String[] args) {
//    	HashMap<String, Item> itemCollection = new HashMap<String, Item>();
//    	try {
//    		FileInputStream fileIn = new FileInputStream("resources/sample.txt");
//			BufferedReader br = new BufferedReader(new InputStreamReader(fileIn));
//			  ArrayList<String[]> items =  new ArrayList<>();
//			  String[] itemInfo;
//			  String line;
//		      
//			  while ((line = br.readLine()) != null) {
//		          if(line.contains("NAME")) {
//		        	  continue;
//		          }
//		          else {
////		        	  line = line.replaceAll("\\*", " ");
//		        	  itemInfo = line.split("\\s{2}");
//		        	  items.add(itemInfo);
//		          }
//		      }
//		     
//			  Iterator<String[]> elements = items.iterator();
//		      while(elements.hasNext()) {
//		    	  String[] current = elements.next();
//		    	  itemCollection.put(current[0], new Item(current[0],current[1],Double.parseDouble(current[2]),Integer.parseInt(current[3])));
//		      }
//		      
//		      fileIn.close();
//		  }
//		catch(Exception e) {
//			e.printStackTrace();
//		}
//	}
}
