/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;

import Model.Deliveries;
import Model.DeliveryLoader;
import Model.DeliveryStaff;
import Model.OrderLoader;
import Model.Orders;
import Model.UserProfileLoader;
import Model.UserProfileManager;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dan
 */
public class ManageDeliveryStaffView extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form ManageDeliveryStaffView
     */
    public ManageDeliveryStaffView() {
        initComponents();
        loadTable();
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
        tblDeliveryStaff = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnViewAll = new javax.swing.JButton();
        btnAddDeliveryStaff = new javax.swing.JButton();
        btnDeleteDeliveryStaff = new javax.swing.JButton();
        btnEditDeliveryStaff = new javax.swing.JButton();
        btnMainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDeliveryStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDeliveryStaff);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("Manage Delivery Staff Accounts");

        btnViewAll.setText("Refresh");
        btnViewAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAllActionPerformed(evt);
            }
        });

        btnAddDeliveryStaff.setText("Add Staff");
        btnAddDeliveryStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddDeliveryStaffActionPerformed(evt);
            }
        });

        btnDeleteDeliveryStaff.setText("Delete Staff");
        btnDeleteDeliveryStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteDeliveryStaffActionPerformed(evt);
            }
        });

        btnEditDeliveryStaff.setText("Edit Staff");
        btnEditDeliveryStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditDeliveryStaffActionPerformed(evt);
            }
        });

        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnMainMenu)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(txtSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnViewAll)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 524, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnEditDeliveryStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnDeleteDeliveryStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnAddDeliveryStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(156, 156, 156))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEditDeliveryStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteDeliveryStaff)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddDeliveryStaff)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(btnMainMenu)
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadTable(){
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
        model.addColumn("Delivery Staff ID");
        model.addColumn("Name");
        
        
        ArrayList<DeliveryStaff> deliverystaffs = new UserProfileLoader().loadDeliveryStaff();
        
        for(int i = 0; i < deliverystaffs.size(); i++){
            String deliveryId = deliverystaffs.get(i).getDeliveryStaffId();
            String name = deliverystaffs.get(i).getDeliveryStaffName();
            Object[] data = {deliveryId, name};
            model.addRow(data);
        }
        tblDeliveryStaff.setModel(model);
    }
    
      private void loadTable(String search){
        model = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
               return false;
            }
        };
        model.addColumn("Delivery Staff ID");
        model.addColumn("Name");

        
        ArrayList<DeliveryStaff> deliverystaffs = new UserProfileLoader().loadDeliveryStaff(search);
        
        for(int i = 0; i < deliverystaffs.size(); i++){
            String deliverystaffId = deliverystaffs.get(i).getDeliveryStaffId();
            String name = deliverystaffs.get(i).getDeliveryStaffName();
            
            Object[] data = {deliverystaffId, name};
            model.addRow(data);
        }
        tblDeliveryStaff.setModel(model);
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
        String search = txtSearch.getText();
        loadTable(search);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnViewAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAllActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btnViewAllActionPerformed

    private void btnAddDeliveryStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddDeliveryStaffActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new AddDeliveryStaffView().setVisible(true);
    }//GEN-LAST:event_btnAddDeliveryStaffActionPerformed

    private void btnDeleteDeliveryStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteDeliveryStaffActionPerformed
        // TODO add your handling code here:
        if(tblDeliveryStaff.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select a manager to remove!");
            return;
        }
        int rowSelect = tblDeliveryStaff.getSelectedRow();
        String deliverystaffId = (String)model.getValueAt(rowSelect, 0);
        
        DeliveryLoader d = new DeliveryLoader();
        ArrayList<Deliveries> deliveries = d.load();
        for(int i = 0; i < deliveries.size(); i++){
            if(deliveries.get(i).getDeliveryStaff().getDeliveryStaffId().equals(deliverystaffId)){
                JOptionPane.showMessageDialog(this, "Delivery Staff has existing deliveries! Please remove deliveries before continuing.");
                break;
            }else{
                
                new UserProfileManager().deleteUser(new UserProfileLoader().createDeliveryStaff(deliverystaffId));
                
            }
        }
        
        
        

        loadTable();
    }//GEN-LAST:event_btnDeleteDeliveryStaffActionPerformed

    private void btnEditDeliveryStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditDeliveryStaffActionPerformed
        // TODO add your handling code here
        if(tblDeliveryStaff.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Please select a manager to edit!");
            return;
        }
        this.dispose();
        int rowSelect = tblDeliveryStaff.getSelectedRow();
        String deliverystaffId = (String)model.getValueAt(rowSelect, 0);
        new EditDeliveryStaffView(new UserProfileLoader().createDeliveryStaff(deliverystaffId)).setVisible(true);
    }//GEN-LAST:event_btnEditDeliveryStaffActionPerformed

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManagerMenuView().setVisible(true);
    }//GEN-LAST:event_btnMainMenuActionPerformed

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
            java.util.logging.Logger.getLogger(ManageDeliveryStaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryStaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryStaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageDeliveryStaffView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageDeliveryStaffView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddDeliveryStaff;
    private javax.swing.JButton btnDeleteDeliveryStaff;
    private javax.swing.JButton btnEditDeliveryStaff;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnViewAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDeliveryStaff;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
