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
public class ItemsLoader {
    
    static final String FILENAME = "Items.txt";
        
    public ArrayList<Items> load(){
        ArrayList<Items> inventoryArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row, txtId, txtName, txtDescription;
            Items item;
            double txtPrice;
            int txtQty;
            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                txtName = str[1];
                txtDescription = str[2];
                txtPrice = Double.parseDouble(str[3]);
                txtQty = Integer.parseInt(str[4]);
                
                item = new Items(txtId, txtName, txtDescription, txtPrice, txtQty);
                inventoryArrayList.add(item);
                
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryArrayList;
    }
    
    public ArrayList<Items> load(String search){
        ArrayList<Items> inventoryArrayList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row, txtId, txtName, txtDescription;
            Items item;
            double txtPrice;
            int txtQty;
            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                txtName = str[1];
                txtDescription = str[2];
                if(!(txtId.matches(search+".*")||txtName.matches(search +".*")
                        ||txtDescription.matches(search+".*"))){
                    continue;
                }
                txtPrice = Double.parseDouble(str[3]);             
                txtQty = Integer.parseInt(str[4]);

                item = new Items(txtId, txtName, txtDescription, txtPrice, txtQty);
                inventoryArrayList.add(item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventoryArrayList;
        
    }
    
    public Items createItem(String itemID){
         try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row, txtId, txtName, txtDescription;
            Items item;
            double txtPrice;
            int txtQty;
            br.readLine();
            while ((row = br.readLine()) != null) {
                String str[] = row.split("\\|\\|");
                txtId = str[0];
                
                if(!txtId.equals(itemID)){
                    continue;
                }
                txtName = str[1];
                txtDescription = str[2];        
                txtPrice = Double.parseDouble(str[3]);
                txtQty = Integer.parseInt(str[4]);        
                
                item = new Items(txtId, txtName, txtDescription, txtPrice, txtQty);

                return item;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return null;  
    }
    
}
