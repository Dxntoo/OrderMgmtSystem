/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;


import javax.swing.table.DefaultTableModel;
import Model.Feedback;
import Model.FeedbackLoader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dan
 */
public class FeedbackView extends javax.swing.JFrame {
    DefaultTableModel feedbackmodel;
    /**
     * Creates new form FeedbackView
     */
    public FeedbackView() {
        initComponents();
        loadFeedbackTable();
        
    }
    
    private void loadFeedbackTable(){ //this is polymorphism
        DefaultTableModel feedbackmodel = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        FeedbackLoader f = new FeedbackLoader();
        ArrayList<Feedback> FeedbackArrayList = f.load();
        feedbackmodel.addColumn("Feedback ID");
        feedbackmodel.addColumn("Feedback");

        for(int i = 0; i < FeedbackArrayList.size(); i++){
            String feedbackId = FeedbackArrayList.get(i).getFeedbackID();
            String feedback = FeedbackArrayList.get(i).getFeedback();
            Object[] data = {feedbackId, feedback};
            feedbackmodel.addRow(data);
        }
        tblFeedback.setModel(feedbackmodel);
    }
    
    private void loadFeedbackTable(String search){ //this is polymorphism
        DefaultTableModel feedbackmodel = new javax.swing.table.DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        FeedbackLoader f = new FeedbackLoader();
        ArrayList<Feedback> FeedbackArrayList = f.load(search);
        feedbackmodel.addColumn("Feedback ID");
        feedbackmodel.addColumn("Feedback");

        for(int i = 0; i < FeedbackArrayList.size(); i++){
            String feedbackId = FeedbackArrayList.get(i).getFeedbackID();
            String feedback = FeedbackArrayList.get(i).getFeedback();
            Object[] data = {feedbackId, feedback};
            feedbackmodel.addRow(data);
        }
        tblFeedback.setModel(feedbackmodel);
    }
    
    void showFeedback(){
        
        feedbackmodel = (DefaultTableModel)tblFeedback.getModel();

        int selectedRowIndex = tblFeedback.getSelectedRow();

        lblFeedbackID.setText(feedbackmodel.getValueAt(selectedRowIndex,0).toString());
        txtDesc.setText(feedbackmodel.getValueAt(selectedRowIndex,1).toString());
        
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
        tblFeedback = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        lblFeedbackID = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtSearchFeedback = new javax.swing.JTextField();
        btnSearchFeedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFeedback.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        tblFeedback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeedbackMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFeedback);
        if (tblFeedback.getColumnModel().getColumnCount() > 0) {
            tblFeedback.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        lblFeedbackID.setText("ID");

        txtDesc.setColumns(20);
        txtDesc.setLineWrap(true);
        txtDesc.setRows(4);
        jScrollPane2.setViewportView(txtDesc);

        jLabel1.setText("ID:");

        btnMainMenu.setText("Main Menu");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel2.setText("Feedback Menu");

        btnSearchFeedback.setText("Search");
        btnSearchFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMainMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblFeedbackID)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRefresh))
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(txtSearchFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchFeedback)))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(246, 246, 246))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearchFeedback))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRefresh)
                    .addComponent(lblFeedbackID)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnMainMenu)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

     
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        loadFeedbackTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void tblFeedbackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeedbackMouseClicked
        // TODO add your handling code here:
        showFeedback();
    }//GEN-LAST:event_tblFeedbackMouseClicked

    private void btnMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMainMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new ManagerMenuView().setVisible(true);
    }//GEN-LAST:event_btnMainMenuActionPerformed

    private void btnSearchFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFeedbackActionPerformed
        // TODO add your handling code here:
        String search = txtSearchFeedback.getText();
        loadFeedbackTable(search);
    }//GEN-LAST:event_btnSearchFeedbackActionPerformed

    

    
    
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
            java.util.logging.Logger.getLogger(FeedbackView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeedbackView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeedbackView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeedbackView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeedbackView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearchFeedback;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFeedbackID;
    private javax.swing.JTable tblFeedback;
    private javax.swing.JTextArea txtDesc;
    private javax.swing.JTextField txtSearchFeedback;
    // End of variables declaration//GEN-END:variables
}