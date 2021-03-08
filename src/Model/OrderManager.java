package Model;

import java.io.*;

/**
 *
 * @author Kai Wen
 */
public class OrderManager {
    
    private static final String FILENAME = "Orders.txt";
    private static final String FILEHEADER = "Order Id||Customer Id||Order Items|| Total Price (RM)" + System.lineSeparator();    

    public void addOrder(Orders order) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME, true))) {
            String toWrite = order.getOrderId() + "||" + order.getCustomer().getCustomerId() +
                    "||" + formatOrderItems(order) + "||" + order.getTotalPrice() + System.lineSeparator();
            bw.write(toWrite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(int i = 0; i < order.getOrderedItems().size(); i++){
            new ItemsManager().updateItems(order.getOrderedItems().get(i).getItems(), 
                    order.getOrderedItems().get(i).getQuantity());
        }
        
    }

    public void editOrder(Orders order) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                String txtId = data[0];
                if(order.getOrderId().equals(txtId)){
                    fileData += order.getOrderId() + "||" + order.getCustomer().getCustomerId() +
                            "||" + this.formatOrderItems(order) + "||" + order.getTotalPrice() + System.lineSeparator();
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
    
        public void editOrder(Orders order, double price) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                String txtId = data[0];
                if(order.getOrderId().equals(txtId)){
                    fileData += order.getOrderId() + "||" + order.getCustomer().getCustomerId() +
                            "||" + this.formatOrderItems(order) + "||" + price + System.lineSeparator();
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

    public void deleteOrder(Orders order) {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
            String row;
            String fileData = "";
            br.readLine();
            while ((row = br.readLine())!= null){
                String data[] = row.split("\\|\\|");
                String txtId = data[0];
                if(!(order.getOrderId().equals(txtId))){
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

    private String formatOrderItems(Orders order){
        String items = "";
        for (int i = 0; i < order.getOrderedItems().size(); i++) {
            //add a comma if the records are not ending, no comma if is the last one
            if (i != order.getOrderedItems().size() - 1) {
                items += "(" + order.getOrderedItems().get(i).getItems().getItemID() + ","
                        + order.getOrderedItems().get(i).getQuantity() + ");";
            } else {
                items += "(" + order.getOrderedItems().get(i).getItems().getItemID() + ","
                        + order.getOrderedItems().get(i).getQuantity() + ")";
            }
        }
        return items;
    }
}
