/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author ht-19
 */
public class UserProfileLoader {
    private static final String USERFILENAME = "user.txt";
    
    public Customer createCustomer(String customerId){
        String row;      
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            while((row = br.readLine())!= null){
                String[] str = row.split("\\|\\|");
                String txtUserId = str[0];
                String txtUsername = str[1];
                String txtCustomerId = str[3];
                
                if(customerId.equals(txtCustomerId)){
                    return new Customer(txtUserId, txtUsername, txtCustomerId);//UserID, Username, CustomerID
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Customer> loadCustomer(){
        ArrayList<Customer> customers = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtCustomerId = data[3];
                if(txtCustomerId.substring(0, 1).equals("C")){
                    customers.add(new Customer(txtUserId, txtUsername, txtCustomerId));
                }               
            }
            return customers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Customer> loadCustomer(String search){
        ArrayList<Customer> customers = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtCustomerId = data[3];
                if(txtCustomerId.substring(0, 1).equals("C")){
                    Customer c = new Customer(txtUserId,txtUsername, txtCustomerId);
                    if(c.getCustomerId().matches(search+".*")|| c.getCustomerName().matches(search+".*")){
                        customers.add(c);
                    }              
                }               
            }
            return customers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
     public ArrayList<Manager> loadManager(){
         ArrayList<Manager> managers = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtCustomerId = data[3];
                if(txtCustomerId.substring(0, 1).equals("M")){
                    managers.add(new Manager(txtUserId,txtUsername, txtCustomerId));             
                }               
            }
            return managers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;       
    }
    
    public ArrayList<Manager> loadManager(String search){
         ArrayList<Manager> managers = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtCustomerId = data[3];
                if(txtCustomerId.substring(0, 1).equals("M")){
                    Manager m = new Manager(txtUserId,txtUsername, txtCustomerId);
                    if(m.getManagerId().matches(search+".*")|| m.getManagerName().matches(search+".*")
                            || m.getManagerEmployeeId().matches(search+".*")){
                        managers.add(m);
                    }              
                }               
            }
            return managers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;       
    }
    
    public Manager createManager(String managerId){
        String row;      
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            while((row = br.readLine())!= null){
                String[] str = row.split("\\|\\|");
                String txtUserId = str[0];
                String txtUsername = str[1];
                String txtManagerId = str[3];
                
                if(managerId.equals(txtManagerId)){
                    return new Manager(txtUserId, txtUsername, txtManagerId);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
    
    public ArrayList<DeliveryStaff> loadDeliveryStaff(){
         ArrayList<DeliveryStaff> DeliveryStaffs = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtDeliveryStaffId = data[3];
                if(txtDeliveryStaffId.substring(0, 1).equals("D")){
                    DeliveryStaffs.add(new DeliveryStaff(txtUserId,txtUsername, txtDeliveryStaffId));             
                }               
            }
            return DeliveryStaffs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;       
    }
    
    public ArrayList<DeliveryStaff> loadDeliveryStaff(String search){
         ArrayList<DeliveryStaff> DeliveryStaffs = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String txtUserId = data[0];
                String txtUsername = data[1];
                String txtDeliveryStaffId = data[3];
                if(txtDeliveryStaffId.substring(0, 1).equals("D")){
                    DeliveryStaff d = new DeliveryStaff(txtUserId,txtUsername, txtDeliveryStaffId);
                    if(d.getDeliveryStaffId().matches(search+".*")|| d.getDeliveryStaffName().matches(search+".*")){
                        DeliveryStaffs.add(d);
                    }              
                }               
            }
            return DeliveryStaffs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;       
    }
    
    public DeliveryStaff createDeliveryStaff(String DeliveryStaffId){
        String row;      
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            while((row = br.readLine())!= null){
                String[] str = row.split("\\|\\|");
                String txtUserId = str[0];
                String txtUsername = str[1];
                String txtDeliveryStaffId = str[3];
                
                if(DeliveryStaffId.equals(txtDeliveryStaffId)){
                    return new DeliveryStaff(txtUserId, txtUsername, txtDeliveryStaffId);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
