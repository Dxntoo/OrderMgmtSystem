package View.Manager;


import Model.UserProfileLoader;
import Model.Items;
import Model.Orders;
import Model.OrderedItems;
import Model.OrderManager;
import Model.ItemsLoader;
import Model.ItemsManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kai Wen
 */
public class EditOrderView extends javax.swing.JFrame {
    
    Orders order;
    DefaultTableModel modelOrderItem, modelProduct;

    /**
     * Creates new form EditOrderView
     */
    public EditOrderView() {
        initComponents();
    }
    
    public EditOrderView(Orders order){
        this.order = order;
        initComponents();
        loadProductTable();
        loadOrderItemTable();
    }
    
    private void loadProductTable(){
        modelProduct = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
                
        ItemsLoader p = new ItemsLoader();
        ArrayList<Items> inventoryArrayList = p.load();
        modelProduct.addColumn("Item ID");
        modelProduct.addColumn("Item Name");
        modelProduct.addColumn("Size");
        modelProduct.addColumn("Item Price (RM)");
        modelProduct.addColumn("Item Quantity"); 
        
        for(int i = 0; i < inventoryArrayList.size(); i++){
            String itemID = inventoryArrayList.get(i).getItemID();
            String itemName = inventoryArrayList.get(i).getItemName();
            String itemDescription = inventoryArrayList.get(i).getSize();
            String itemPrice = Double.toString(inventoryArrayList.get(i).getItemPrice());
            String itemQuantity = Integer.toString(inventoryArrayList.get(i).getItemQuantity());
            Object[] data = {itemID, itemName, itemDescription, itemPrice, itemQuantity};
            modelProduct.addRow(data);
        }
        tblProduct.setModel(modelProduct);
    }
    
    private void loadOrderItemTable(){
        modelOrderItem  = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
        modelOrderItem.addColumn("Item ID");
        modelOrderItem.addColumn("Item Name");
        modelOrderItem.addColumn("Item Description");
        modelOrderItem.addColumn("Item Price (RM)");
        modelOrderItem.addColumn("Quantity");
        modelOrderItem.addColumn("Total Price (RM))");
        
        ArrayList<OrderedItems> orderItems = order.getOrderedItems();
        double grandTotal = 0;
        for(int i = 0; i < orderItems.size(); i++){
            String itemID = orderItems.get(i).getItems().getItemID();
            String itemName = orderItems.get(i).getItems().getItemName();            
            String itemDescription = orderItems.get(i).getItems().getSize();
            double itemPrice = orderItems.get(i).getItems().getItemPrice();
            int itemQuantity = orderItems.get(i).getQuantity();
            double totalPrice = itemPrice * itemQuantity;
            grandTotal += totalPrice;
            Object[] data = {itemID, itemName, itemDescription, itemPrice, itemQuantity, totalPrice};
            modelOrderItem.addRow(data);
        }
        tblOrderItem.setModel(modelOrderItem);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        btnEditQuantity = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderItem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblProduct);

        btnConfirm.setText("Save Changes");
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setText("Back");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove Item");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        btnEditQuantity.setText("Edit Quantity");
        btnEditQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuantityActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("Edit Order");

        tblOrderItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblOrderItem);

        jLabel2.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel2.setText("Items");

        jLabel3.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel3.setText("Ordered Items");

        btnAdd.setText("Add Item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAdd)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEditQuantity)
                                        .addGap(28, 28, 28)
                                        .addComponent(btnRemove)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnConfirm, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(226, 226, 226))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addGap(15, 15, 15)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRemove)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnConfirm)
                        .addComponent(btnEditQuantity)))
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        // TODO add your handling code here:
        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to confirm changes?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (dialogResult) {
            case JOptionPane.YES_OPTION:
            // Saving code here
            double totalprice = 0;
            for(int i = 0; i < modelOrderItem.getRowCount(); i++){
                
                double price = Double.parseDouble((String)modelOrderItem.getValueAt(i,5).toString());
                totalprice += price;
            
                
                new OrderManager().editOrder(order, price);
            
                String itemID = (String)modelOrderItem.getValueAt(i, 0);
                int stock = Integer.parseInt((String)modelOrderItem.getValueAt(i,4).toString());
                new ItemsManager().updateItems(
                                new ItemsLoader().createItem(itemID),
                        stock
                );
            }
            
            JOptionPane.showMessageDialog(this, "Changes saved!");
            this.dispose();
            new ManageOrderView().setVisible(true);
            break;
            case JOptionPane.NO_OPTION:
            return;
            case JOptionPane.CLOSED_OPTION:
            return;
            default:
            break;
        }

    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManageOrderView().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(tblOrderItem.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an item to remove!");
            return;
        }

        int rowSelect = tblOrderItem.getSelectedRow();
        String itemID = (String)modelOrderItem.getValueAt(rowSelect, 0);
        int quantity = (int)modelOrderItem.getValueAt(rowSelect, 4);

        //remove from array list
        for(int i = 0; i < order.getOrderedItems().size(); i++){
            if(order.getOrderedItems().get(i).getItems().getItemID().equals(itemID)){
                order.getOrderedItems().remove(i);
            }
        }

        //add back quantity to product table
        for(int i = 0; i < modelProduct.getRowCount(); i++){
            if(modelProduct.getValueAt(i, 0).equals(itemID)){
                int stock = Integer.parseInt((String)modelProduct.getValueAt(i, 4));
                modelProduct.setValueAt(Integer.toString(stock + quantity), i, 4);
            }
        }
        loadOrderItemTable();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuantityActionPerformed
        // TODO add your handling code here:
        if(tblOrderItem.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an item to edit!");
            return;
        }

        int rowSelect = tblOrderItem.getSelectedRow();
        String productId = (String)modelOrderItem.getValueAt(rowSelect, 0);
        int currentQuantity = (int)modelOrderItem.getValueAt(rowSelect, 4);

        String strQuantity = JOptionPane.showInputDialog(this, "Change quantity to:");
        int stock = 0;
        int quantity = 0;

        for(int i = 0; i < modelProduct.getRowCount(); i++){
            if(modelProduct.getValueAt(i, 0).equals(productId)){
                stock = Integer.parseInt((String)modelProduct.getValueAt(i, 4));
                break;
            }
        }

        if(strQuantity != null){
            try{
                quantity= Integer.parseInt(strQuantity);
                if(quantity <= 0){
                    JOptionPane.showMessageDialog(this, "Please enter a valid quantity! (1 or more)");
                    return;
                }else if(quantity > stock + currentQuantity){
                    JOptionPane.showMessageDialog(this, "The quantity exceeded available stock!");
                    return;
                }
            } catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter a number!");
                return;
            }
        }

        for(int i = 0; i < modelProduct.getRowCount(); i++){
            if(modelProduct.getValueAt(i, 0).equals(productId)){
                modelProduct.setValueAt(Integer.toString(stock + currentQuantity - quantity), i, 4);
                break;
            }
        }

        for(int i = 0; i < order.getOrderedItems().size(); i++){
            if(order.getOrderedItems().get(i).getItems().getItemID().equals(productId)){
                order.getOrderedItems().get(i).setQuantity(quantity);
            }
        }
        loadOrderItemTable();

    }//GEN-LAST:event_btnEditQuantityActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(tblProduct.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(this, "Please select a product!");
            return;
        }
        String strQuantity = JOptionPane.showInputDialog(this, "Quantity:");
        if(strQuantity != null){
            int quantity;
            try{
                quantity = Integer.parseInt(strQuantity);
                if(quantity <= 0){
                    JOptionPane.showMessageDialog(this, "Please enter a valid quantity! (1 or more)");
                    return;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter a number!");
                return;
            }

            //Get selected row's product data
            int rowSelect = tblProduct.getSelectedRow();
            System.out.println(rowSelect);
            String productId = (String)modelProduct.getValueAt(rowSelect, 0);

            int stock = Integer.parseInt((String)modelProduct.getValueAt(rowSelect, 4));

            //Check stock amount
            if(quantity > stock){
                JOptionPane.showMessageDialog(this, "The quantity exceeded available stock!");
                return;
            }

            //Check if already exists in order items
            for(int i = 0; i <order.getOrderedItems().size(); i++){
                if(order.getOrderedItems().get(i).getItems().getItemID().equals(productId)){
                    JOptionPane.showMessageDialog(this, "This item exists in the list of order items.");
                    return;
                }
            }
            Items itm = new ItemsLoader().createItem(productId);
            OrderedItems o = new OrderedItems(itm, quantity);
            order.getOrderedItems().add(o);
            modelProduct.setValueAt(Integer.toString(stock - quantity), rowSelect, 4);

            loadOrderItemTable();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EditOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditOrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JButton btnEditQuantity;
    private javax.swing.JButton btnRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblOrderItem;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}