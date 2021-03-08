package View.DeliveryStaff;

import Model.CustomerLoader;
import Model.Deliveries;
import Model.DeliveryLoader;
import Model.DeliveryManager;
import Model.DeliveryStaff;
import Model.DeliveryStaffLoader;
import Model.OrderLoader;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kai Wen
 */
public class ManageDeliveryView extends javax.swing.JFrame {
    
    DefaultTableModel model;
    DeliveryStaff deliverystaff;
    DefaultComboBoxModel modelDay = new DefaultComboBoxModel();
    DefaultComboBoxModel modelMonth = new DefaultComboBoxModel();
    DefaultComboBoxModel modelYear = new DefaultComboBoxModel();

    public ManageDeliveryView() {
        initComponents();
        loadTable();
        loadDayCombo();
        loadMonthCombo();
        loadYearCombo(); 
    }
    
    public ManageDeliveryView(DeliveryStaff deliverystaff) {
        this.deliverystaff = deliverystaff;
        initComponents();
        loadTable();
        loadDayCombo();
        loadMonthCombo();
        loadYearCombo(); 
    }
    private void loadTable(){
    model = new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int row, int column){
             return false;
         }
     };
     model.addColumn("Delivery ID");
     model.addColumn("Order ID");
     model.addColumn("Customer Id");
     model.addColumn("Customer Name");
     model.addColumn("Total Price (RM)");
     model.addColumn("Delivery Date");
     model.addColumn("Delivery Staff ID");

     ArrayList<Deliveries> delivery = new DeliveryLoader().load(this.deliverystaff);//loads deliveryArrayList
     for(int i = 0; i < delivery.size(); i++){//iterates per delivery item in the array list
        String deliveryId = delivery.get(i).getDeliveryID();
        String customerId = delivery.get(i).getCustomer().getCustomerId();
        String orderId = delivery.get(i).getOrder().getOrderId();
        String customerName = delivery.get(i).getCustomer().getCustomerName();
        double totalPrice = delivery.get(i).getOrder().getTotalPrice();
        String date = delivery.get(i).getDate();
        String deliveryStaffId = delivery.get(i).getDeliveryStaff().getDeliveryStaffId();
        
        //Object[] data = {deliveryId, customerId, customerName, date, deliveryStaffId};
        Object[] data = {deliveryId, orderId, customerId, customerName, totalPrice, date, deliveryStaffId};
        model.addRow(data);
     }
     DeliveryTable.setModel(model);
    }
    
    private void loadTable(String search){
     model = new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int row, int column){
             return false;
         }
     };
     model.addColumn("Delivery ID");
     model.addColumn("Order ID");
     model.addColumn("Customer Id");
     model.addColumn("Customer Name");
     model.addColumn("Total Price (RM)");
     model.addColumn("Delivery Date");
     model.addColumn("Delivery Staff ID");
     

     ArrayList<Deliveries> delivery = new DeliveryLoader().load(search);//loads deliveryArrayList
     for(int i = 0; i < delivery.size(); i++){//iterates per delivery item in the array list
        String deliveryId = delivery.get(i).getDeliveryID();
        String customerId = delivery.get(i).getCustomer().getCustomerId();
        String orderId = delivery.get(i).getOrder().getOrderId();
        String customerName = delivery.get(i).getCustomer().getCustomerName();
        double totalPrice = delivery.get(i).getOrder().getTotalPrice();
        String date = delivery.get(i).getDate();
        String deliveryStaffId = delivery.get(i).getDeliveryStaff().getDeliveryStaffId();
        
        //Object[] data = {deliveryId, customerId, customerName, date, deliveryStaffId};
        Object[] data = {deliveryId, orderId, customerId, customerName, totalPrice, date, deliveryStaffId};
        model.addRow(data);
     }
     DeliveryTable.setModel(model);
    }

    private void loadDayCombo(){
        //For Days
        for(int i = 1 ; i <= 30; i++){
            modelDay.addElement(i);
        }
        comboDay.setModel(modelDay);
    }
    
    private void loadMonthCombo(){
        //For Months
        for(int i = 1; i <= 12; i++){
            modelMonth.addElement(i);
        }
        comboMonth.setModel(modelMonth);
    }
    
    private void loadYearCombo(){
        //For Years
        for(int i = 2020; i <= 2050; i++){
            modelYear.addElement(i);
        }
        comboYear.setModel(modelYear);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DeliveryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ViewDelivery = new javax.swing.JButton();
        EditDelivery = new javax.swing.JButton();
        AddDelivery = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        DeleteDelivery = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        SearchDelivery = new javax.swing.JButton();
        comboDay = new javax.swing.JComboBox<>();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        DeliveryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(DeliveryTable);

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("Manage Deliveries");

        ViewDelivery.setText("View All Deliveries");
        ViewDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ViewDeliveryActionPerformed(evt);
            }
        });

        EditDelivery.setText("Edit Delivery");
        EditDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditDeliveryActionPerformed(evt);
            }
        });

        AddDelivery.setText("Add Delivery");
        AddDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDeliveryActionPerformed(evt);
            }
        });

        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        DeleteDelivery.setText("Delete Delivery");
        DeleteDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteDeliveryActionPerformed(evt);
            }
        });

        SearchDelivery.setText("Search");
        SearchDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchDeliveryActionPerformed(evt);
            }
        });

        comboDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel2.setText("Edit Delivery");

        jLabel3.setText("Day");

        jLabel4.setText("Month");

        jLabel5.setText("Year");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(336, 336, 336))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(DeleteDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtSearch)
                                .addGap(18, 18, 18)
                                .addComponent(SearchDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ViewDelivery)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AddDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(EditDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)))
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchDelivery, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(EditDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ViewDelivery)
                    .addComponent(AddDelivery))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteDelivery)
                .addGap(39, 39, 39)
                .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDeliveryActionPerformed
        this.dispose();
        new AddDeliveryView(this.deliverystaff).setVisible(true);
    }//GEN-LAST:event_AddDeliveryActionPerformed

    private void SearchDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchDeliveryActionPerformed
        String search = txtSearch.getText();
        loadTable(search);
    }//GEN-LAST:event_SearchDeliveryActionPerformed

    private void ViewDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ViewDeliveryActionPerformed
        loadTable();
    }//GEN-LAST:event_ViewDeliveryActionPerformed

    private void EditDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditDeliveryActionPerformed
        if(DeliveryTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an order to edit!");
            return;
        }
        
        int rowSelect = DeliveryTable.getSelectedRow();
        loadTable();
         
         String orderId = (String)model.getValueAt(rowSelect, 1);
         String customerId = (String)model.getValueAt(rowSelect, 2);
         String deliveryStaffId = this.deliverystaff.getDeliveryStaffId();
         String date = String.join("/", comboDay.getSelectedItem().toString(), comboMonth.getSelectedItem().toString(), comboYear.getSelectedItem().toString());
         String deliveryId = (String)model.getValueAt(rowSelect, 0);
         Deliveries delivery = new Deliveries(deliveryId,new OrderLoader().createOrder(orderId),new CustomerLoader().createCustomer(customerId), date, new DeliveryStaffLoader().createDeliveryStaff(deliveryStaffId));
         new DeliveryManager().editDelivery(delivery);
         
                   
         JOptionPane.showMessageDialog(this, "Delivery changed!");
         
         loadTable();
        
        //int rowSelect = DeliveryTable.getSelectedRow();
        //String deliverId = (String)model.getValueAt(rowSelect, 0);
        //new EditDeliveryView(new DeliveryTable().createOrder(deliverId)).setVisible(true);
        
        
    }//GEN-LAST:event_EditDeliveryActionPerformed

    private void DeleteDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteDeliveryActionPerformed
        if(DeliveryTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select an order to remove!");
            return;
        }

        int rowSelect = DeliveryTable.getSelectedRow();
        String deliveryId = (String)model.getValueAt(rowSelect, 0);
        new DeliveryManager().deleteDelivery(new DeliveryLoader().createDelivery(deliveryId));

        loadTable();
    }//GEN-LAST:event_DeleteDeliveryActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.dispose();
        new DeliveryStaffMenuView(this.deliverystaff).setVisible(true);
    }//GEN-LAST:event_BackActionPerformed

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
            java.util.logging.Logger.getLogger(ManageDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDeliveryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDelivery;
    private javax.swing.JButton Back;
    private javax.swing.JButton DeleteDelivery;
    private javax.swing.JTable DeliveryTable;
    private javax.swing.JButton EditDelivery;
    private javax.swing.JButton SearchDelivery;
    private javax.swing.JButton ViewDelivery;
    private javax.swing.JComboBox<String> comboDay;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
