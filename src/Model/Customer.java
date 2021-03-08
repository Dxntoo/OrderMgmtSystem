package Model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Kai Wen
 */
public class Customer extends User{
    
    private String customerId, customerName, customerAddress, customerPhone;
    private static final String FILENAME = "customer.txt";
    
        public Customer(String customerId){
        this.customerId = customerId;
        String row, fileCustId, fileCustName, fileAddress, filePhone;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                fileCustId = data[0];
                fileCustName = data[1];
                fileAddress = data[2];
                filePhone = data[3];
                
                if (fileCustId.equals(customerId)) {
                    customerName = fileCustName;
                    customerAddress = fileAddress;
                    customerPhone = filePhone;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
        public Customer(String userId, String username,String customerId){
        super(userId,username);
        this.customerId = customerId;
        String row, fileCustId, fileCustName, fileAddress, filePhone;
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                fileCustId = data[0];
                fileCustName = data[1];
                //nric removed
                fileAddress = data[2];
                filePhone = data[3];
                
                if (fileCustId.equals(customerId)) {
                    customerName = fileCustName;
                    customerAddress = fileAddress;
                    customerPhone = filePhone;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public Customer(String username, String customerName, String customerAddress, String customerPhone){
        super(username);
        this.customerId = Utility.generateId(FILENAME, "C");
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }
    
    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    
    @Override
    public String toString(){
        return "Customer";
    }
}
