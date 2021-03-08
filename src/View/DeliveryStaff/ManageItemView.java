package View.DeliveryStaff;

import Model.DeliveryStaff;
import Model.ItemsLoader;
import Model.Items;
import Model.ItemsManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kai Wen
 */
public class ManageItemView extends javax.swing.JFrame {

    DefaultTableModel model;
    DeliveryStaff deliverystaff;
    public ManageItemView() {
        initComponents();
        loadTable();
    }
    
    public ManageItemView(DeliveryStaff deliverystaff) {
        initComponents();
        loadTable();
        this.deliverystaff = deliverystaff;
    }
    
    private void loadTable(){
        model = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
                
        ItemsLoader p = new ItemsLoader();
        ArrayList<Items> itemsArrayList = p.load();
        model.addColumn("Item ID");
        model.addColumn("Item Name");
        model.addColumn("Size");
        model.addColumn("Item Price");
        model.addColumn("Item Quantity"); 
        for(int i = 0; i < itemsArrayList.size(); i++){
            String itemId = itemsArrayList.get(i).getItemID();
            String itemName = itemsArrayList.get(i).getItemName();
            String itemDescription = itemsArrayList.get(i).getSize();
            String itemPrice = Double.toString(itemsArrayList.get(i).getItemPrice());
            String itemQuantity = Integer.toString(itemsArrayList.get(i).getItemQuantity());
            Object[] data = {itemId, itemName, itemDescription, itemPrice, itemQuantity};
            model.addRow(data);
        }
        ItemTable.setModel(model);
    }
    
    private void loadTable(String search){
        model = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
                
        ItemsLoader p = new ItemsLoader();
        ArrayList<Items> itemsArrayList = p.load(search);
        model.addColumn("Item ID");
        model.addColumn("Item Name");
        model.addColumn("Size");
        model.addColumn("Item Price");
        model.addColumn("Item Quantity"); 
        for(int i = 0; i < itemsArrayList.size(); i++){
            String itemId = itemsArrayList.get(i).getItemID();
            String itemName = itemsArrayList.get(i).getItemName();
            String itemDescription = itemsArrayList.get(i).getSize();
            String itemPrice = Double.toString(itemsArrayList.get(i).getItemPrice());
            String itemQuantity = Integer.toString(itemsArrayList.get(i).getItemQuantity());
            Object[] data = {itemId, itemName, itemDescription, itemPrice, itemQuantity};
            model.addRow(data);
        }
        ItemTable.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ViewItems = new javax.swing.JButton();
        EditItem = new javax.swing.JButton();
        DeleteItem = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        ManageItemLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        AddItem = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        SearchItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ViewItems.setText("View Items");
        ViewItems.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewItemsActionPerformed(evt);
            }
        });

        EditItem.setText("Edit Items");
        EditItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditItemActionPerformed(evt);
            }
        });

        DeleteItem.setText("Delete Item");
        DeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteItemActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        ManageItemLabel.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        ManageItemLabel.setText("Manage Items");

        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(ItemTable);

        AddItem.setText("Add Items");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        SearchItem.setText("Search");
        SearchItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SearchItem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 812, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ViewItems)
                                    .addGap(180, 180, 180)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(182, 182, 182)))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ManageItemLabel)
                        .addGap(362, 362, 362))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(ManageItemLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchItem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ViewItems)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Back)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EditItem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ViewItemsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewItemsActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_ViewItemsActionPerformed

    private void EditItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditItemActionPerformed
        // TODO add your handling code here:
        if(ItemTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select a product to edit!");
            return;
        }
        int rowSelect = ItemTable.getSelectedRow();
        String itemId = (String)model.getValueAt(rowSelect, 0);

        Items itm = new ItemsLoader().createItem(itemId);
        new EditItemView(itm,this.deliverystaff).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_EditItemActionPerformed

    private void DeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteItemActionPerformed
        // TODO add your handling code here:
        if(ItemTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an Item to Remove!");
            return;
        }
        int rowSelect = ItemTable.getSelectedRow();
        String itemId = (String)model.getValueAt(rowSelect, 0);
        new ItemsManager().deleteItem( //Changed product to item
                new ItemsLoader().createItem(itemId)
        );

        loadTable();
    }//GEN-LAST:event_DeleteItemActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.dispose();
        new DeliveryStaffMenuView(this.deliverystaff).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

    private void SearchItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        loadTable(search);
    }//GEN-LAST:event_SearchItemActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        this.dispose();
        new AddItemView(this.deliverystaff).setVisible(true);
    }//GEN-LAST:event_AddItemActionPerformed

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
            java.util.logging.Logger.getLogger(ManageItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageItemView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageItemView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddItem;
    private javax.swing.JButton Back;
    private javax.swing.JButton DeleteItem;
    private javax.swing.JButton EditItem;
    private javax.swing.JTable ItemTable;
    private javax.swing.JLabel ManageItemLabel;
    private javax.swing.JButton SearchItem;
    private javax.swing.JButton ViewItems;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
