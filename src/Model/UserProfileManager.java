package Model;

import CustomException.UserDuplicateException;
import CustomException.UsernameDuplicateException;
import java.io.*;

public class UserProfileManager {
    private static final String USERFILENAME = "user.txt";
    private static final String MANAGERFILENAME = "manager.txt";
    private static final String CUSTOMERFILENAME = "customer.txt";
    private static final String DELIVERYSTAFFFILENAME = "deliverystaff.txt";
    
    private static final String USERFILEHEADER = "UserID||Username||Password||PositionID" + System.lineSeparator();
    private static final String CUSTOMERFILEHEADER = "CustomerId||CustomerName||CustomerAddress||CustomerPhone"
            + System.lineSeparator();
    private static final String MANAGERFILEHEADER = "ManagerId||ManagerName||ManagerEmployeeId" + System.lineSeparator();
    private static final String DELIVERYSTAFFFILEHEADER = "DeliveryStaffId||DeliveryStaffName" + System.lineSeparator();
    
    private void checkDuplicate(Customer c) throws UsernameDuplicateException, UserDuplicateException{
        try (BufferedReader brUser = new BufferedReader(new FileReader(USERFILENAME));
            BufferedReader brCustomer = new BufferedReader(new FileReader(CUSTOMERFILENAME)) ) {
            String row;
            brUser.readLine();
            while ((row = brUser.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String username = data[1];
                if(username.equals(c.getUsername())){
                    throw new UsernameDuplicateException();
                }
            }
            while ((row = brCustomer.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String phone = data[3];
                if(phone.equals(c.getCustomerPhone())){
                    throw new UserDuplicateException();
                }
            }
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void checkDuplicate(Manager m) throws UsernameDuplicateException, UserDuplicateException{
        try (BufferedReader brUser = new BufferedReader(new FileReader(USERFILENAME));
            BufferedReader brCustomer = new BufferedReader(new FileReader(MANAGERFILENAME)) ) {
            String row;
            brUser.readLine();
            while ((row = brUser.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String username = data[1];
                if(username.equals(m.getUsername())){
                    throw new UsernameDuplicateException();
                }
            }
            while ((row = brCustomer.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String employeeId = data[2];
                if(employeeId.equals(m.getManagerEmployeeId())){
                    throw new UserDuplicateException();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void checkDuplicate(DeliveryStaff d) throws UsernameDuplicateException, UserDuplicateException{
        try (BufferedReader brUser = new BufferedReader(new FileReader(USERFILENAME));
            BufferedReader brDeliveryStaff = new BufferedReader(new FileReader(DELIVERYSTAFFFILENAME)) ) {
            String row;
            brUser.readLine();
            while ((row = brUser.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String username = data[1];
                if(username.equals(d.getUsername())){
                    throw new UsernameDuplicateException();
                }
            }
            while ((row = brDeliveryStaff.readLine())!= null){
                String[] data = row.split("\\|\\|");
                String deliverystaffId = data[0];
                if(deliverystaffId.equals(d.getDeliveryStaffId())){
                    throw new UserDuplicateException();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //Add new Customer
    public void addUser(Customer c, char[] password) throws UsernameDuplicateException, UserDuplicateException {
        checkDuplicate(c);
        try (BufferedWriter bwUser = new BufferedWriter(new FileWriter(USERFILENAME, true));
             BufferedWriter bwCustomer = new BufferedWriter(new FileWriter(CUSTOMERFILENAME, true))) {
            bwUser.write(c.getUserId() + "||" + c.getUsername() + "||" +
                    new String(password) + "||" + c.getCustomerId() + System.lineSeparator());
            bwCustomer.write(c.getCustomerId() + "||" + c.getCustomerName() + "||"
                    + c.getCustomerAddress() + "||" + c.getCustomerPhone() + System.lineSeparator());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //Add new Manager
    public void addUser(Manager m, char[] password) throws UsernameDuplicateException, UserDuplicateException {
        checkDuplicate(m);
        try (BufferedWriter bwUser = new BufferedWriter(new FileWriter(USERFILENAME, true));
             BufferedWriter bwManager = new BufferedWriter(new FileWriter(MANAGERFILENAME, true))) {
            bwUser.write(m.getUserId() + "||" + m.getUsername() + "||" +
                    new String(password) + "||" + m.getManagerId() + System.lineSeparator());
            bwManager.write(m.getManagerId() + "||" + m.getManagerName() + "||" + m.getManagerEmployeeId() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //Add new Delivery Staff
    public void addUser(DeliveryStaff d, char[] password) throws UsernameDuplicateException, UserDuplicateException {
        checkDuplicate(d);//check exception files
        try (BufferedWriter bwUser = new BufferedWriter(new FileWriter(USERFILENAME, true));
             BufferedWriter bwDeliveryStaff = new BufferedWriter(new FileWriter(DELIVERYSTAFFFILENAME, true))) {
            bwUser.write(d.getUserId() + "||" + d.getUsername() + "||" +
                    new String(password) + "||" + d.getDeliveryStaffId() + System.lineSeparator());
            bwDeliveryStaff.write(d.getDeliveryStaffId() + "||" + d.getDeliveryStaffName() + System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    //Edit customer
    public void editUser(Customer c) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (c.getCustomerId().equals(txtId)) {
                    fileData += c.getCustomerId() + "||" +  c.getCustomerName() + "||" +
                            c.getCustomerAddress() + "||" + c.getCustomerPhone() + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMERFILENAME))){
                bw.write(CUSTOMERFILEHEADER);
                bw.write(fileData);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    //Edit Manager
    public void editUser(Manager m) {
        try (BufferedReader br = new BufferedReader(new FileReader(MANAGERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (m.getManagerId().equals(txtId)) {
                    fileData += m.getManagerId() + "||" + m.getManagerName() + "||" + m.getManagerEmployeeId()
                            + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(MANAGERFILENAME))){
                bw.write(MANAGERFILEHEADER);
                bw.write(fileData);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void editUser(DeliveryStaff d) {
        try (BufferedReader br = new BufferedReader(new FileReader(DELIVERYSTAFFFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (d.getDeliveryStaffId().equals(txtId)) {
                    fileData += d.getDeliveryStaffId() + "||" + d.getDeliveryStaffName()+ System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(DELIVERYSTAFFFILENAME))){
                bw.write(DELIVERYSTAFFFILEHEADER);
                bw.write(fileData);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Customer c) {
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (!(c.getCustomerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(CUSTOMERFILENAME))){
                bw.write(CUSTOMERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[3];
                if (!(c.getCustomerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(USERFILENAME))){
                bw.write(USERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(Manager m) {
        try (BufferedReader br = new BufferedReader(new FileReader(MANAGERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (!(m.getManagerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(MANAGERFILENAME))){
                bw.write(MANAGERFILEHEADER);
                bw.write(fileData);
            }     
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[3];
                if (!(m.getManagerId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(USERFILENAME))){
                bw.write(USERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    public void deleteUser(DeliveryStaff d) {
        try (BufferedReader br = new BufferedReader(new FileReader(DELIVERYSTAFFFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (!(d.getDeliveryStaffId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(DELIVERYSTAFFFILENAME))){
                bw.write(DELIVERYSTAFFFILEHEADER);
                bw.write(fileData);
            }     
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader br = new BufferedReader(new FileReader(USERFILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[3];
                if (!(d.getDeliveryStaffId().equals(txtId))) {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(USERFILENAME))){
                bw.write(USERFILEHEADER);
                bw.write(fileData);
            }          
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
