package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DeliveryStaff extends User {
    protected String deliveryStaffId;
    private String deliveryStaffName;
    private static final String FILENAME = "deliverystaff.txt";

    
    public DeliveryStaff(String userId, String username, String deliverystaffId) {
        super(userId, username);
        this.deliveryStaffId = deliverystaffId;
        String row, filedeliveryStaffId, filedeliveryStaffName;
        try(BufferedReader br = new BufferedReader(new FileReader(FILENAME))){
            br.readLine();
            while((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                filedeliveryStaffId = data[0];
                filedeliveryStaffName = data[1];
                
                
                if(filedeliveryStaffId.equals(deliverystaffId)){
                    this.deliveryStaffName = filedeliveryStaffName;
                    
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DeliveryStaff.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DeliveryStaff.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public DeliveryStaff(String deliverystaffId){
        this.deliveryStaffId = deliverystaffId;
        String row, fileDeliveryStaffId, fileDeliveryStaffName;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                fileDeliveryStaffId = data[0];
                fileDeliveryStaffName = data[1];
                
                
                if (fileDeliveryStaffId.equals(deliverystaffId)) {
                    deliveryStaffId = fileDeliveryStaffId;
                    deliveryStaffName = fileDeliveryStaffName;
                    
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public DeliveryStaff(String userId, String username, String DeliveryStaffName, String DeliverystaffId){
        super(username);
        this.deliveryStaffId = Utility.generateId(FILENAME, "D");
        this.deliveryStaffName = DeliveryStaffName;
        
    }
    public String getDeliveryStaffId(){
        return deliveryStaffId;
    }
    public String getDeliveryStaffName(){
        return deliveryStaffName;
    }
    
    public void setDeliveryStaffId(String deliveryStaffId){
        this.deliveryStaffId = deliveryStaffId;
    }
    public void setDeliveryStaffName(String deliveryStaffName){
        this.deliveryStaffName = deliveryStaffName;
    }
    

    @Override
    public String toString() {
        return "Delivery Staff";
    }
}
