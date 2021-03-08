package Model;

import Model.DeliveryStaff;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Kai Wen
 */
public class Deliveries {
    
    private String DeliveryID;
    private Orders order;
    private Customer customer;
    private String date;
    private DeliveryStaff deliverystaff; //Need to get the delivery staff id out 
    
    
    private static String FILENAME = "Delivery.txt";
    
    public Deliveries(Orders order, Customer customer, String date, DeliveryStaff deliveryStaff){
        this.DeliveryID = Utility.generateId(FILENAME, "D");
        this.order = order;
        this.date = date;
        this.customer = customer;
        this.deliverystaff = deliveryStaff;
    }
    
    public Deliveries(String DeliveryID, Orders order, Customer customer, String date, DeliveryStaff deliverystaff){
        this.DeliveryID = DeliveryID;
        this.order = order;
        this.date = date;
        this.customer = customer;
        //missing delivery staff Id (How to do set deliverystaff.deliverystaffID = parameter???)
        this.deliverystaff = deliverystaff;
    }
    
    
    
    public String getDeliveryID(){
        return DeliveryID;
    }
    
    public DeliveryStaff getDeliveryStaff(){
        return deliverystaff;
    }
    
    public Orders getOrder(){
        return order;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public String getDate(){
        return date;
    }
    
}
