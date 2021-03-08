package Model;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kai Wen
 */
public class ItemsManager {
    private static final String FILENAME = "Items.txt";
    private static final String FILEHEADER = "Item Id||Item Name||Size||Item Price||Item Quantity" + System.lineSeparator();

    public void addItem(Items i) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            bw.write(i.getItemID() + "||" + i.getItemName() + "||" + i.getSize() + "||" + i.getItemPrice() + "||" + i.getItemQuantity() + System.lineSeparator());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void editItem(Items i) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0]; 
                if (i.getItemID().equals(txtId)) {
                    fileData += i.getItemID() + "||" + i.getItemName() + "||" + i.getSize() + "||" + i.getItemPrice() + "||" + i.getItemQuantity() + System.lineSeparator();
                } else {
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

    public void deleteItem(Items i) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                if (!(i.getItemID().equals(txtId))) { 
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
    
    public void updateItems(Items i, int quantity) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine()) != null) {
                String[] data = row.split("\\|\\|");
                String txtId = data[0];
                int txtStock = Integer.parseInt(data[4]);
                if (i.getItemID().equals(txtId)) { //HERE HERE HERE HERE HERE HERE FOR EDIT ORDER
                    fileData += i.getItemID() + "||" + i.getItemName() + "||" + i.getSize() + "||" + i.getItemPrice()
                            + "||" + Integer.toString(txtStock - quantity) + System.lineSeparator();
                } else {
                    fileData += row + System.lineSeparator();
                }
            }
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME))){
                bw.write(FILEHEADER);
                bw.write(fileData);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ItemsManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ItemsManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
