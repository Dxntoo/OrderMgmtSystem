package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Kai Wen
 */

public class Orders {

    private String orderId;
    private Customer customer;
    private ArrayList<OrderedItems> orderedItems;    
    private static String FILENAME = "Orders.txt";
    private double TotalPrice;
    
    public Orders(Customer customer, ArrayList<OrderedItems> o, double TotalPrice) {
        this.orderId = Utility.generateId(FILENAME, "O");
        this.customer = customer;
        orderedItems = o;
        this.TotalPrice = TotalPrice;
    }
    
    public Orders(Customer customer, ArrayList<OrderedItems> o) {
        this.orderId = Utility.generateId(FILENAME, "O");
        this.customer = customer;
        orderedItems = o;
        
    }
    
    public Orders(String orderId, Customer customer, ArrayList<OrderedItems> o, double TotalPrice) {
        this.orderId = orderId;
        this.customer = customer;
        orderedItems = o;
        this.TotalPrice = TotalPrice;
    }
    
    public String getOrderId() {
        return orderId;
    }

    public Customer getCustomer() {
        return customer;
    }
    
    public double getTotalPrice(){
        return TotalPrice;
    }

    public ArrayList<OrderedItems> getOrderedItems() {
        return orderedItems;
    }
}
