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
public class CustomerLoader {

    private static final String CUSTOMERFILENAME = "Customer.txt";

    public Customer createCustomer(String customerId) {
        String row;
        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            while ((row = br.readLine()) != null) {
                String[] str = row.split("\\|\\|");
                String CustId = str[0];
                String CustName = str[1];
                String CustAdd = str[2];
                String CustPhone = str[3];

                if (customerId.equals(CustId)) {
                    return new Customer(CustId);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Customer> loadCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(CUSTOMERFILENAME))) {
            br.readLine();
            String row;
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String CustId = data[0];
                String CustName = data[1];
                String CustAdd = data[2];
                String CustPhone = data[3];
                if (CustId.substring(0, 1).equals("C")) {
                    customers.add(new Customer(CustId));
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

}
