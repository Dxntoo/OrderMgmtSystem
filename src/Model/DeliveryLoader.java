package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kai Wen
 */
public class DeliveryLoader {
        private DeliveryStaff deliverystaff;
        private static final String FILENAME = "Delivery.txt";
        ArrayList<Deliveries> deliveryArrayList = new ArrayList<>();
        
        public Deliveries createDelivery(String DeliveryId){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileDeliveryOrder = data[0];
                
                if(!DeliveryId.equals(fileDeliveryOrder)){
                    continue;
                }
                
                String fileOrderId = data[1];
                String fileCustomerId = data[2];
                String fileDate = data[3];
                String fileDeliveryStaffId = data[4];

                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);
                DeliveryStaff d = new DeliveryStaffLoader().createDeliveryStaff(fileDeliveryStaffId);
                Orders order = new OrderLoader().createOrder(fileOrderId);
                
                return new Deliveries(fileDeliveryOrder, order, customer, fileDate, d);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(DeliveryLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(DeliveryLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        
        
    
        public ArrayList<Deliveries> load(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileDeliveryId = data[0];
                String fileOrderId = data[1];
                String fileCustomerId = data[2];
                String fileDate = data[3];
                String fileDeliveryStaffId = data[4];//reads staff id from file
                
                //if function
                
                
                //Used to get customer, orders and delivery staff data
                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);
                Orders order = new OrderLoader().createOrder(fileOrderId);
                DeliveryStaff ds = new DeliveryStaffLoader().createDeliveryStaff(fileDeliveryStaffId);//create new Delivery Staff instance
                
               
                //Add the delivery objs to the arraylist for loading
                deliveryArrayList.add(new Deliveries(fileDeliveryId, order, customer, fileDate, ds));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deliveryArrayList;
    }
        
        public ArrayList<Deliveries> load(DeliveryStaff deliverystaff){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileDeliveryId = data[0];
                String fileOrderId = data[1];
                String fileCustomerId = data[2];
                String fileDate = data[3];
                String fileDeliveryStaffId = data[4];//reads staff id from file
                
                if(!deliverystaff.deliveryStaffId.equals(fileDeliveryStaffId)){
                    continue;
                }
                
                //Used to get customer, orders and delivery staff data
                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);
                Orders order = new OrderLoader().createOrder(fileOrderId);
                DeliveryStaff ds = new DeliveryStaffLoader().createDeliveryStaff(fileDeliveryStaffId);//create new Delivery Staff instance
                
               
                //Add the delivery objs to the arraylist for loading
                deliveryArrayList.add(new Deliveries(fileDeliveryId, order, customer, fileDate, ds));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deliveryArrayList;
    }
        
        public ArrayList<Deliveries> load(String search){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileDeliveryId = data[0];
                String fileOrderId = data[1];
                String fileCustomerId = data[2];
                String fileDate = data[3];
                String fileDeliveryStaffId = data[4];
                
                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);
                Orders order = new OrderLoader().createOrder(fileOrderId);
                DeliveryStaff d = new DeliveryStaffLoader().createDeliveryStaff(fileDeliveryStaffId);
                
                //if all fields does not match search, go to next iteration
                        
                deliveryArrayList.add(new Deliveries(fileDeliveryId, order, customer, fileDate, d));
                
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deliveryArrayList;
    }
    
}
