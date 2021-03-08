package Model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import Model.Deliveries;
import Model.Orders;
import java.util.ArrayList;
/**
 *
 * @author Kai Wen
 */
public class DeliveryManager {
    
    private static final String FILENAME = "Delivery.txt";
    private static final String FILEHEADER = "Delivery Id||Order Id||Customer Id||Date||DeliveryStaffId" + System.lineSeparator();    

    public void addDelivery(Deliveries delivery) {
      
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            String toWrite = delivery.getDeliveryID() + "||" + delivery.getOrder().getOrderId() + "||" + delivery.getCustomer().getCustomerId() 
                    + "||" + delivery.getDate() + "||" + delivery.getDeliveryStaff().deliveryStaffId + System.lineSeparator();
            bw.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    public void editDelivery(Deliveries delivery) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                String txtId = data[0];
                if(delivery.getDeliveryID().equals(txtId)){
                    fileData += delivery.getDeliveryID() + "||" + delivery.getOrder().getOrderId() + "||" + delivery.getCustomer().getCustomerId()
                            + "||" + delivery.getDate() + "||" + delivery.getDeliveryStaff().deliveryStaffId + System.lineSeparator();
                }else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))){
                bw.write(FILEHEADER);
                bw.write(fileData);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteDelivery(Deliveries delivery) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                String txtId = data[0];
                if(!(delivery.getDeliveryID().equals(txtId))){
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))){
                bw.write(FILEHEADER);
                bw.write(fileData);  
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
    public void deleteDelivery(String orderId) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                String txtId = data[1];
                if(!(orderId.equals(txtId))){
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))){
                bw.write(FILEHEADER);
                bw.write(fileData);  
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    
    
}
