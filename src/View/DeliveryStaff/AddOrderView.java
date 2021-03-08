package View.DeliveryStaff;

import Model.Customer;
import Model.DeliveryStaff;
import Model.UserProfileLoader;
import Model.Items;
import Model.ItemsLoader;
import Model.OrderManager;
import Model.OrderedItems;
import Model.Orders;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kai Wen
 */
public class AddOrderView extends javax.swing.JFrame {
    
    Orders order;
    DefaultTableModel modelOrderItem, modelProduct;
    DefaultComboBoxModel modelCombo = new DefaultComboBoxModel();
    DeliveryStaff deliverystaff;
    
    public AddOrderView() {
        initComponents();
        loadComboBox();
        loadProductTable();
        loadOrderItemTable();
    }
    
    public AddOrderView(DeliveryStaff deliverystaff) {
        initComponents();
        loadComboBox();
        loadProductTable();
        loadOrderItemTable();
        this.deliverystaff = deliverystaff;
    }
    
    private void loadComboBox(){
        ArrayList<Customer> customers = new UserProfileLoader().loadCustomer();
        for(Customer c: customers){
            modelCombo.addElement(c.getCustomerId());
        }
        comboCustomer.setModel(modelCombo);
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
        modelOrderItem.addColumn("Item Price");
        modelOrderItem.addColumn("Quantity");
        modelOrderItem.addColumn("Total Price (RM)");
        

        tblOrderItem.setModel(modelOrderItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        comboCustomer = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduct = new javax.swing.JTable();
        btnEditQuantity = new javax.swing.JButton();
        btnAddOrder = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrderItem = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel3.setText("Items to Order");

        comboCustomer.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Customer:");

        btnAdd.setText("Add Item");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

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

        btnEditQuantity.setText("Edit Quantity");
        btnEditQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditQuantityActionPerformed(evt);
            }
        });

        btnAddOrder.setText("Add Order");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("Add New Order");

        btnCancel.setText("Back");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

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
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Items");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(comboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jSeparator1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(464, 464, 464)
                                .addComponent(btnAddOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnEditQuantity)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(207, 207, 207))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAdd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditQuantity)
                        .addComponent(btnRemove))
                    .addComponent(btnAddOrder))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancel)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        if(tblProduct.getSelectedRow()== -1){
            JOptionPane.showMessageDialog(this, "Please select a product!");
            return;
        }
        String strQuantity = JOptionPane.showInputDialog(this, "Quantity:");
        if(strQuantity != null){
            int Quantity;
            try{
                Quantity = Integer.parseInt(strQuantity);
                if(Quantity <= 0){
                    JOptionPane.showMessageDialog(this, "Please enter a valid quantity! (1 or more)");
                    return;
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Please enter a number!");
                return;
            }

            //Get selected row's product data
            int rowSelect = tblProduct.getSelectedRow();
            String itemID = (String)modelProduct.getValueAt(rowSelect, 0);
            String itemName = (String)modelProduct.getValueAt(rowSelect, 1);
            String itemDescription = (String)modelProduct.getValueAt(rowSelect, 2);        
            String itemPrice = (String)modelProduct.getValueAt(rowSelect,3);
            double price = Double.parseDouble(itemPrice);
            System.out.println(modelProduct.getValueAt(rowSelect, 4));
            String strStock = (String)modelProduct.getValueAt(rowSelect, 4);
            int itemQuantity = Integer.parseInt(strStock);

            //Check stock amount
            if(Quantity > itemQuantity){
                JOptionPane.showMessageDialog(this, "The quantity exceeded available stock!");
                return;
            }

            //Check if already exists in order items
            for(int i = 0; i <tblOrderItem.getRowCount(); i++){
                if(modelOrderItem.getValueAt(i, 0).equals(itemID)){
                    JOptionPane.showMessageDialog(this, "This item exists in the list of order items.");
                    return;
                }
            }
            String TotalPrice = Double.toString(price * Quantity);
            Object[] rowData = {itemID, itemName, itemDescription, price, strQuantity, TotalPrice};
            modelOrderItem.addRow(rowData);
            modelProduct.setValueAt(Integer.toString(itemQuantity - Quantity), rowSelect, 4);

        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(tblOrderItem.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an item to remove!");
            return;
        }

        int rowSelect = tblOrderItem.getSelectedRow();
        String itemID = (String)modelOrderItem.getValueAt(rowSelect, 0);
        String strQuantity = (String)modelOrderItem.getValueAt(rowSelect, 4);
        int quantity = Integer.parseInt(strQuantity);

        modelOrderItem.removeRow(rowSelect);//removes selected row 

        //add back quantity to product table
        for(int i = 0; i < modelProduct.getRowCount(); i++){
            if(modelProduct.getValueAt(i, 0).equals(itemID)){
                int stock = Integer.parseInt((String)modelProduct.getValueAt(i, 4));
                modelProduct.setValueAt(Integer.toString(stock + quantity), i, 4);
            }
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnEditQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditQuantityActionPerformed
        // TODO add your handling code here:
        if(tblOrderItem.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an item to edit!");
            return;
        }

        int rowSelect = tblOrderItem.getSelectedRow();
        String productId = (String)modelOrderItem.getValueAt(rowSelect, 0);
        String strCurrentQuantity = (String)modelOrderItem.getValueAt(rowSelect, 4);
        int currentQuantity = Integer.parseInt(strCurrentQuantity);
        String strPrice = (String)modelOrderItem.getValueAt(rowSelect, 3).toString();
        double price = Double.parseDouble(strPrice);

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

        modelOrderItem.setValueAt(strQuantity, rowSelect, 4);
        modelOrderItem.setValueAt(Double.toString(quantity * price), rowSelect, 5);
    }//GEN-LAST:event_btnEditQuantityActionPerformed

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed
        // TODO add your handling code here:
        double totalprice = 0;
        
        if(modelOrderItem.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Please add an item to cart!");
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to place order?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (dialogResult) {
            case JOptionPane.YES_OPTION:
            // Saving code here
            ArrayList<OrderedItems> orderItems = new ArrayList<>();
            for(int i = 0; i < modelOrderItem.getRowCount(); i++){
                String itemID = (String)modelOrderItem.getValueAt(i, 0);
                int quantity = Integer.parseInt((String)modelOrderItem.getValueAt(i,4));
                orderItems.add(
                    new OrderedItems(
                        new ItemsLoader().createItem(itemID),
                        quantity
                    )
                );
            }
            for(int i = 0; i < modelOrderItem.getRowCount(); i++){
                double price = Double.parseDouble((String)modelOrderItem.getValueAt(i,5));
                totalprice += price;
                if(i == modelOrderItem.getRowCount() - 1){
                    Orders order = new Orders(
                        new UserProfileLoader().createCustomer(comboCustomer.getSelectedItem().toString()),
                        orderItems, totalprice
                    );
                    new OrderManager().addOrder(order);
                }
            }
            JOptionPane.showMessageDialog(this, "Order added!");
            this.dispose();
            new ManageOrderView(this.deliverystaff).setVisible(true);
            break;
            case JOptionPane.NO_OPTION:
            return;
            case JOptionPane.CLOSED_OPTION:
            return;
            default:
            break;
        }
    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManageOrderView().setVisible(true);
    }//GEN-LAST:event_btnCancelActionPerformed

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
            java.util.logging.Logger.getLogger(AddOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEditQuantity;
    private javax.swing.JButton btnRemove;
    private javax.swing.JComboBox<String> comboCustomer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblOrderItem;
    private javax.swing.JTable tblProduct;
    // End of variables declaration//GEN-END:variables
}
