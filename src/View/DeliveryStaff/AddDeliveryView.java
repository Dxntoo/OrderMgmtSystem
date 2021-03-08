/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.DeliveryStaff;

import Model.CustomerLoader;
import Model.UserProfileLoader;
import Model.Deliveries;
import Model.DeliveryLoader;
import Model.DeliveryManager;
import Model.DeliveryStaff;
import Model.DeliveryStaffLoader;
import Model.OrderLoader;
import Model.Orders;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kai Wen
 */
public class AddDeliveryView extends javax.swing.JFrame {

    Deliveries delivery;
    DeliveryStaff deliverystaff;
    DefaultTableModel modelOrders;
    DefaultComboBoxModel modelDay = new DefaultComboBoxModel();
    DefaultComboBoxModel modelMonth = new DefaultComboBoxModel();
    DefaultComboBoxModel modelYear = new DefaultComboBoxModel();
    DeliveryLoader d = new DeliveryLoader();
    ArrayList<Deliveries> deliveryArrayList = d.load();

    public AddDeliveryView() {
        initComponents();
        loadOrdersTable();
        loadDayCombo();
        loadMonthCombo();
        loadYearCombo();
    }

    public AddDeliveryView(DeliveryStaff deliverystaff) {
        this.deliverystaff = deliverystaff;
        initComponents();
        loadOrdersTable();
        loadDayCombo();
        loadMonthCombo();
        loadYearCombo();
    }

    private void loadOrdersTable() {
        modelOrders = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        OrderLoader p = new OrderLoader();
        ArrayList<Orders> ordersArrayList = p.load();

        DeliveryLoader d = new DeliveryLoader();
        ArrayList<Deliveries> deliveriesArrayList = d.load();
        

        modelOrders.addColumn("Order ID");
        modelOrders.addColumn("Customer ID");
        modelOrders.addColumn("Customer Name");
        modelOrders.addColumn("Total Price");

        
        for (int i = 0; i < ordersArrayList.size(); i++) {

            String orderId = ordersArrayList.get(i).getOrderId();//gets all the orderId from given arraylist 
            int z = 0;// creates a counter

            for (int j = 0; j < deliveriesArrayList.size(); j++) {

                String ORDERID = deliveriesArrayList.get(j).getOrder().getOrderId();//gets all the orderId from deliveries from the given arraylist
                
                if (!ORDERID.equals(orderId)) { // if there's no orderId in delivery then z increments by one
                    z++;
                    if (z == deliveriesArrayList.size()) { // if z reaches the size, then put data intio table
                        String custId = ordersArrayList.get(i).getCustomer().getCustomerId();
                        String custName = ordersArrayList.get(i).getCustomer().getCustomerName();
                        String totalPrice = Double.toString(ordersArrayList.get(i).getTotalPrice());
                        Object[] data = {orderId, custId, custName, totalPrice};
                        modelOrders.addRow(data);
                        OrdersTable.setModel(modelOrders);

                    }

                }
            }

        }
    }

    private void loadDayCombo() {
        //For Days
        for (int i = 1; i <= 30; i++) {
            modelDay.addElement(i);
        }
        comboDay.setModel(modelDay);
    }

    private void loadMonthCombo() {
        //For Months
        for (int i = 1; i <= 12; i++) {
            modelMonth.addElement(i);
        }
        comboMonth.setModel(modelMonth);
    }

    private void loadYearCombo() {
        //For Years
        for (int i = 2020; i <= 2050; i++) {
            modelYear.addElement(i);
        }
        comboYear.setModel(modelYear);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        OrdersTable = new javax.swing.JTable();
        AddDelivery = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        comboDay = new javax.swing.JComboBox<>();
        comboMonth = new javax.swing.JComboBox<>();
        comboYear = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(OrdersTable);

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

        comboDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        comboYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Day");

        jLabel2.setText("Month");

        jLabel3.setText("Year");

        jLabel4.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel4.setText("Add New Delivery");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(151, 179, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(AddDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(147, 147, 147))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(253, 253, 253))))
            .addGroup(layout.createSequentialGroup()
                .addGap(204, 204, 204)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Back, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(86, 86, 86))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AddDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDeliveryActionPerformed
        if (OrdersTable.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an order to Deliver!");
            return;
        }

        int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to place order?", "Confirm",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        switch (dialogResult) {
            case JOptionPane.YES_OPTION:

                int rowSelect = OrdersTable.getSelectedRow();
                String orderId = (String) modelOrders.getValueAt(rowSelect, 0);

                String customerId = (String) modelOrders.getValueAt(rowSelect, 1);
                String date = String.join("/", comboDay.getSelectedItem().toString(), comboMonth.getSelectedItem().toString(), comboYear.getSelectedItem().toString());
                String deliveryStaffId = this.deliverystaff.getDeliveryStaffId();

                Deliveries delivery = new Deliveries(new OrderLoader().createOrder(orderId), new CustomerLoader().createCustomer(customerId), date, new DeliveryStaffLoader().createDeliveryStaff(deliveryStaffId));
                new DeliveryManager().addDelivery(delivery);

                JOptionPane.showMessageDialog(this, "Delivery added!");

                this.dispose();
                new ManageDeliveryView(this.deliverystaff).setVisible(true);
                break;
            case JOptionPane.NO_OPTION:
                return;
            case JOptionPane.CLOSED_OPTION:
                return;
            default:
                break;
        }
    }//GEN-LAST:event_AddDeliveryActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        this.dispose();
        new ManageDeliveryView(this.deliverystaff).setVisible(true);
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
            java.util.logging.Logger.getLogger(AddDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDeliveryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddDeliveryView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDelivery;
    private javax.swing.JButton Back;
    private javax.swing.JTable OrdersTable;
    private javax.swing.JComboBox<String> comboDay;
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<String> comboYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
