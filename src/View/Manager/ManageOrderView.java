package View.Manager;

import Model.DeliveryManager;
import Model.OrderLoader;
import Model.OrderManager;
import Model.OrderedItems;
import Model.Orders;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kai Wen
 */
public class ManageOrderView extends javax.swing.JFrame {
    
    DefaultTableModel model;
    
    public ManageOrderView() {
        initComponents();
        loadTable();
    }
    

    private void loadTable(){
    model = new DefaultTableModel(){
         @Override 
         public boolean isCellEditable(int row, int column){
             return false;
         }
     };
     model.addColumn("Order ID");
     model.addColumn("Customer ID");
     model.addColumn("Customer Name");
     model.addColumn("Ordered Items");
     model.addColumn("Total Price (RM)");

     ArrayList<Orders> orders = new OrderLoader().load();//Arraylist consisting of Order type and loads from OrderLoader.
     for(int i = 0; i < orders.size(); i++){
        String orderId = orders.get(i).getOrderId();
        String orderedItems = formatOrderItems(orders.get(i).getOrderedItems());
        String customerName = orders.get(i).getCustomer().getCustomerName();//Gets Customer Name from Order.java
        String customerId = orders.get(i).getCustomer().getCustomerId();//Gets Customer ID from Order.java
        double totalPrice = orders.get(i).getTotalPrice();
        Object[] data = {orderId, customerId , customerName,orderedItems, totalPrice};
        model.addRow(data);
     }
     OrderTable.setModel(model);
    }
    
    private void loadTable(String search){
     model = new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int row, int column){
             return false;
         }
     };
     model.addColumn("Order ID");
     model.addColumn("Customer ID");
     model.addColumn("Customer Name");
     model.addColumn("Ordered Items");
     model.addColumn("Total Price (RM)");
     

     ArrayList<Orders> orders = new OrderLoader().load(search);
     for(int i = 0; i < orders.size(); i++){
        String orderId = orders.get(i).getOrderId();
        String customerId = orders.get(i).getCustomer().getCustomerId();
        String customerName = orders.get(i).getCustomer().getCustomerName();
        String orderedItems = formatOrderItems(orders.get(i).getOrderedItems());
        double totalPrice = orders.get(i).getTotalPrice();
        Object[] data = {orderId, customerId, customerName, orderedItems, totalPrice};
        model.addRow(data);
     }
     OrderTable.setModel(model);
    }
    
     private String formatOrderItems(ArrayList<OrderedItems> o){
        String items = "";
        for (int i = 0; i < o.size(); i++) {
            //add a comma if the records are not ending, no comma if is the last one
            if (i != o.size() - 1) {
                items += "(" + o.get(i).getItems().getItemName() + "," + o.get(i).getQuantity() + "),  ";
            } else {
                items += "(" + o.get(i).getItems().getItemName() + "," + o.get(i).getQuantity() + ")";
            }
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddOrder = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        SearchOrders = new javax.swing.JButton();
        ViewOrder = new javax.swing.JButton();
        EditOrder = new javax.swing.JButton();
        DeleteOrder = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AddOrder.setText("Add Order");
        AddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrderActionPerformed(evt);
            }
        });

        SearchOrders.setText("Search");
        SearchOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchOrdersActionPerformed(evt);
            }
        });

        ViewOrder.setText("View All Orders");
        ViewOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewOrderActionPerformed(evt);
            }
        });

        EditOrder.setText("Edit Order");
        EditOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditOrderActionPerformed(evt);
            }
        });

        DeleteOrder.setText("Delete Order");
        DeleteOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteOrderActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("Manage Orders");

        OrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(OrderTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(SearchOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(ViewOrder)
                                .addGap(81, 81, 81)
                                .addComponent(AddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EditOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchOrders, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ViewOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(EditOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(AddOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DeleteOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOrderActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AddOrderView().setVisible(true);
    }//GEN-LAST:event_AddOrderActionPerformed

    private void SearchOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchOrdersActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        loadTable(search);
    }//GEN-LAST:event_SearchOrdersActionPerformed

    private void ViewOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewOrderActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_ViewOrderActionPerformed

    private void EditOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditOrderActionPerformed
        // TODO add your handling code here:
        if(OrderTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an order to edit!");
            return;
        }

        int rowSelect = OrderTable.getSelectedRow();
        String orderId = (String)model.getValueAt(rowSelect, 0);
        new EditOrderView(new OrderLoader().createOrder(orderId)).setVisible(true);
        this.dispose();

    }//GEN-LAST:event_EditOrderActionPerformed

    private void DeleteOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteOrderActionPerformed
        // TODO add your handling code here:
        if(OrderTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an order to remove!");
            return;
        }

        int rowSelect = OrderTable.getSelectedRow();
        String orderId = (String)model.getValueAt(rowSelect, 0);
        new OrderManager().deleteOrder(new OrderLoader().createOrder(orderId));
        new DeliveryManager().deleteDelivery(orderId);
        loadTable();
    }//GEN-LAST:event_DeleteOrderActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManagerMenuView().setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(ManageOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageOrderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageOrderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddOrder;
    private javax.swing.JButton Back;
    private javax.swing.JButton DeleteOrder;
    private javax.swing.JButton EditOrder;
    private javax.swing.JTable OrderTable;
    private javax.swing.JButton SearchOrders;
    private javax.swing.JButton ViewOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
