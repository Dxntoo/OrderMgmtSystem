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
 * @author Dan
 */
public class DeliveryStaffLoader {
    
     private static final String DELIVERYSTAFFFILENAME = "deliverystaff.txt";
    
        public DeliveryStaff createDeliveryStaff(String deliverystaffId){
        String row;      
        try (BufferedReader br = new BufferedReader(new FileReader(DELIVERYSTAFFFILENAME))) {
            while((row = br.readLine())!= null){
                String[] str = row.split("\\|\\|");
                String deliveryStaffID = str[0];
                
                
                if(deliverystaffId.equals(deliveryStaffID)){
                    return new DeliveryStaff(deliveryStaffID);
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
        ArrayList<DeliveryStaff> deliverystaff = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(DELIVERYSTAFFFILENAME))) {
            br.readLine();
            String row;
            while((row = br.readLine())!= null){
                String[] data = row.split("\\|\\|");            
                String deliveryStaffID = data[0];
                
                
                if(deliveryStaffID.substring(0, 1).equals("D")){
                    deliverystaff.add(new DeliveryStaff(deliveryStaffID));
                }               
            }
            return deliverystaff;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
}
