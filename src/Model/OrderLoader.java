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
public class OrderLoader {
    
    private static final String FILENAME = "Orders.txt";
    ArrayList<Orders> orderArrayList = new ArrayList<>();
    
    public Orders createOrder(String orderId){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileOrderId = data[0];
                
                if(!orderId.equals(fileOrderId)){
                    continue;
                }
                
                String fileCustomerId = data[1];
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(";");
                ArrayList<OrderedItems> orderedItems = new ArrayList<>();
                double fileTotalPrice = Double.parseDouble(data[3]);
                
                //load order items into order
                for(String s : orderItemsData){
                    s = s.substring(1, s.length() - 1);
                    String[] orderItemData = s.split(",");
                    
                    //load product into order item
                    Items item = new ItemsLoader().createItem(orderItemData[0]);                    
                    orderedItems.add(new OrderedItems(item, Integer.parseInt(orderItemData[1])));
                    
                }
                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);
                return new Orders(fileOrderId, customer, orderedItems, fileTotalPrice);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Orders> load(){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileOrderId = data[0];
                String fileCustomerId = data[1];
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(";");
                ArrayList<OrderedItems> orderedItems = new ArrayList<>();
                double fileTotalPrice = Double.parseDouble(data[3]);
                
                //load order items into order
                for(String s : orderItemsData){
                    s = s.substring(1, s.length() - 1);
                    String[] orderItemData = s.split(",");
                    
                    //load product into order item
                    Items item = new ItemsLoader().createItem(orderItemData[0]);                    
                    orderedItems.add(new OrderedItems(item, Integer.parseInt(orderItemData[1])));
                    
                }
                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);//create a new Customer instancce
                orderArrayList.add(new Orders(fileOrderId, customer, orderedItems, fileTotalPrice));//creates a new Order
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
    
    public ArrayList<Orders> load(String search){
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String fileOrderId = data[0];
                String fileCustomerId = data[1];
                Customer customer = new CustomerLoader().createCustomer(fileCustomerId);
                
                //if all fields does not match search, go to next iteration
                if(!(customer.getCustomerId().matches(search+".*")||fileOrderId.matches(search+".*")
                        ||customer.getCustomerName().matches(search+".*"))){
                    continue;
                }
                
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(";");
                ArrayList<OrderedItems> orderItems = new ArrayList<>();
                double fileTotalPrice = Double.parseDouble(data[3]);
                
                //load order items into order
                for(String s : orderItemsData){
                    s = s.substring(1, s.length() - 1);
                    String[] orderItemData = s.split(",");
                    
                    //load product into order item
                    Items item = new ItemsLoader().createItem(orderItemData[0]);                    
                    orderItems.add(new OrderedItems(item, Integer.parseInt(orderItemData[1])));
                    
                }               
                orderArrayList.add(new Orders(fileOrderId, customer, orderItems, fileTotalPrice));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println("cannot read");
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
    
    public ArrayList<Orders> load(Customer customer){
        
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            String row;
            br.readLine();
            while((row = br.readLine())!= null){
                
               String[] data = row.split("\\|\\|");
                String fileOrderId = data[0];
                String fileCustomerId = data[1];
                String fileOrderItems = data[2];
                String orderItemsData[] = fileOrderItems.split(";");
               ArrayList<OrderedItems> orderItems = new ArrayList<>();
               double fileTotalPrice = Double.parseDouble(data[3]);
                
                if(customer.getCustomerId().equals(fileCustomerId)){
                    //load order items into order
                    for(String s : orderItemsData){
                        s = s.substring(1, s.length() - 1);
                        String[] orderItemData = s.split(",");

                        //load product into order item
                        Items item = new ItemsLoader().createItem(orderItemData[0]);                    
                        orderItems.add(new OrderedItems(item, Integer.parseInt(orderItemData[1])));
                    }
                    orderArrayList.add(new Orders(fileOrderId, customer, orderItems, fileTotalPrice));
               }                                
           }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(OrderLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderArrayList;
    }
    
}
