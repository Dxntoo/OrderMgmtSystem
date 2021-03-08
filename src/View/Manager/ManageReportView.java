/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Manager;

import Model.Deliveries;
import Model.DeliveryLoader;
import Model.DeliveryStaff;
import Model.Items;
import Model.ItemsLoader;
import Model.OrderLoader;
import Model.OrderedItems;
import Model.Orders;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;

/**
 *
 * @author Dan
 */
public class ManageReportView extends javax.swing.JFrame {

    DefaultTableModel deliverymodel;
    DefaultTableModel ordermodel;
    DefaultTableModel itemmodel;

    DeliveryStaff deliverystaff;

    /**
     * Creates new form ManageReportView
     */
    public ManageReportView() {
        initComponents();
        deliveryloadTable();
        orderloadTable();
        itemloadTable();

    }

    public void deliveryloadTable() {
        deliverymodel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        deliverymodel.addColumn("Delivery ID");
        deliverymodel.addColumn("Order ID");
        deliverymodel.addColumn("Customer Id");
        deliverymodel.addColumn("Customer Name");
        deliverymodel.addColumn("Total Price (RM)");
        deliverymodel.addColumn("Delivery Date");
        deliverymodel.addColumn("Delivery Staff ID");

        ArrayList<Deliveries> delivery = new DeliveryLoader().load();//loads deliveryArrayList
        for (int i = 0; i < delivery.size(); i++) {//iterates per delivery item in the array list
            String deliveryId = delivery.get(i).getDeliveryID();
            String customerId = delivery.get(i).getCustomer().getCustomerId();
            String orderId = delivery.get(i).getOrder().getOrderId();
            String customerName = delivery.get(i).getCustomer().getCustomerName();
            double totalPrice = delivery.get(i).getOrder().getTotalPrice();
            String date = delivery.get(i).getDate();
            String deliveryStaffId = delivery.get(i).getDeliveryStaff().getDeliveryStaffId();

            //Object[] data = {deliveryId, customerId, customerName, date, deliveryStaffId};
            Object[] data = {deliveryId, orderId, customerId, customerName, totalPrice, date, deliveryStaffId};
            deliverymodel.addRow(data);
        }
        tblDelivery.setModel(deliverymodel);
    }

    public void orderloadTable() {
        ordermodel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ordermodel.addColumn("Order ID");
        ordermodel.addColumn("Customer ID");
        ordermodel.addColumn("Customer Name");
        ordermodel.addColumn("Ordered Items");
        ordermodel.addColumn("Total Price (RM)");

        ArrayList<Orders> orders = new OrderLoader().load();
        for (int i = 0; i < orders.size(); i++) {
            String orderId = orders.get(i).getOrderId();
            String customerId = orders.get(i).getCustomer().getCustomerId();
            String customerName = orders.get(i).getCustomer().getCustomerName();
            String orderedItems = formatOrderItems(orders.get(i).getOrderedItems());
            double totalPrice = orders.get(i).getTotalPrice();
            Object[] data = {orderId, customerId, customerName, orderedItems, totalPrice};
            ordermodel.addRow(data);
        }
        tblOrder.setModel(ordermodel);
    }

    public void itemloadTable() {
        itemmodel = new javax.swing.table.DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        ItemsLoader p = new ItemsLoader();
        ArrayList<Items> itemsArrayList = p.load();
        itemmodel.addColumn("Item ID");
        itemmodel.addColumn("Item Name");
        itemmodel.addColumn("Size");
        itemmodel.addColumn("Item Price");
        itemmodel.addColumn("Item Quantity");
        for (int i = 0; i < itemsArrayList.size(); i++) {
            String itemId = itemsArrayList.get(i).getItemID();
            String itemName = itemsArrayList.get(i).getItemName();
            String itemDescription = itemsArrayList.get(i).getSize();
            String itemPrice = Double.toString(itemsArrayList.get(i).getItemPrice());
            String itemQuantity = Integer.toString(itemsArrayList.get(i).getItemQuantity());
            Object[] data = {itemId, itemName, itemDescription, itemPrice, itemQuantity};
            itemmodel.addRow(data);
        }
        tblItem.setModel(itemmodel);
    }

    private String formatOrderItems(ArrayList<OrderedItems> o) {
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDelivery = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        btnDelivery = new javax.swing.JButton();
        btnOrder = new javax.swing.JButton();
        btnItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnMainMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDelivery.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblDelivery);

        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblOrder);

        tblItem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(tblItem);

        btnDelivery.setText("Export to PDF");
        btnDelivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeliveryActionPerformed(evt);
            }
        });

        btnOrder.setText("Export to PDF");
        btnOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderActionPerformed(evt);
            }
        });

        btnItem.setText("Export to PDF");
        btnItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnItemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lato", 1, 24)); // NOI18N
        jLabel1.setText("Report Manager");

        btnMainMenu.setText("Back");
        btnMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMainMenuActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel2.setText("Deliveries Table");

        jLabel3.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel3.setText("Orders Table");

        jLabel4.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel4.setText("Item Table");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnMainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnItem, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelivery, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane2)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3))))
                        .addGap(61, 61, 61))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDelivery)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOrder)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnItem)
                .addGap(42, 42, 42)
                .addComponent(btnMainMenu)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeliveryActionPerformed
        // TODO add your handling code here:
        String path = "";

        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "-DeliveryReport.pdf"));

            doc.open();
            PdfPTable tbl = new PdfPTable(7);
            PdfPCell title = new PdfPCell(new Paragraph("Delivery Report"));
            title.setColspan(7);
            title.setHorizontalAlignment(Element.ALIGN_CENTER);
            title.setBackgroundColor(BaseColor.ORANGE);

            tbl.addCell(title);
            tbl.addCell("Delivery ID");
            tbl.addCell("Order ID");
            tbl.addCell("Customer ID");
            tbl.addCell("Customer Name");
            tbl.addCell("Total Price");
            tbl.addCell("Delivery Date");
            tbl.addCell("Delivery Staff ID");

            for (int i = 0; i < tblDelivery.getRowCount(); i++) {
                String deliveryId = tblDelivery.getValueAt(i, 0).toString();
                String orderId = tblDelivery.getValueAt(i, 1).toString();
                String customerId = tblDelivery.getValueAt(i, 2).toString();
                String customerName = tblDelivery.getValueAt(i, 3).toString();
                String totalPrice = tblDelivery.getValueAt(i, 4).toString();
                String deliveryDate = tblDelivery.getValueAt(i, 5).toString();
                String deliverystaffId = tblDelivery.getValueAt(i, 6).toString();

                tbl.addCell(deliveryId);
                tbl.addCell(orderId);
                tbl.addCell(customerId);
                tbl.addCell(customerName);
                tbl.addCell(totalPrice);
                tbl.addCell(deliveryDate);
                tbl.addCell(deliverystaffId);
            }

            doc.add(tbl);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageReportView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ManageReportView.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();
    }//GEN-LAST:event_btnDeliveryActionPerformed

    private void btnOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderActionPerformed
        // TODO add your handling code here:

        String path = "";

        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "-OrderReport.pdf"));

            doc.open();
            PdfPTable tbl = new PdfPTable(5);
            PdfPCell title = new PdfPCell(new Paragraph("Order Report"));
            title.setColspan(5);
            title.setHorizontalAlignment(Element.ALIGN_CENTER);
            title.setBackgroundColor(BaseColor.ORANGE);

            tbl.addCell(title);
            tbl.addCell("Order ID");
            tbl.addCell("Customer ID");
            tbl.addCell("Customer Name");
            tbl.addCell("Ordered Items");
            tbl.addCell("Total Price");

            for (int i = 0; i < tblDelivery.getRowCount(); i++) {

                String orderId = tblDelivery.getValueAt(i, 0).toString();
                String customerId = tblDelivery.getValueAt(i, 1).toString();
                String customerName = tblDelivery.getValueAt(i, 2).toString();
                String orderedItems = tblDelivery.getValueAt(i, 3).toString();
                String totalPrice = tblDelivery.getValueAt(i, 4).toString();

                tbl.addCell(orderId);
                tbl.addCell(customerId);
                tbl.addCell(customerName);
                tbl.addCell(orderedItems);
                tbl.addCell(totalPrice);

            }

            doc.add(tbl);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageReportView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ManageReportView.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();
    }//GEN-LAST:event_btnOrderActionPerformed

    private void btnItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnItemActionPerformed
        // TODO add your handling code here:

        String path = "";

        JFileChooser j = new JFileChooser();
        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = j.showSaveDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {
            path = j.getSelectedFile().getPath();
        }

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "-InventoryReport.pdf"));

            doc.open();
            PdfPTable tbl = new PdfPTable(5);
            PdfPCell title = new PdfPCell(new Paragraph("Inventory Report"));
            title.setColspan(5);
            title.setHorizontalAlignment(Element.ALIGN_CENTER);
            title.setBackgroundColor(BaseColor.ORANGE);

            tbl.addCell(title);
            tbl.addCell("Item ID");
            tbl.addCell("Item Name");
            tbl.addCell("Size");
            tbl.addCell("Item Price");
            tbl.addCell("Item Quantity");

            for (int i = 0; i < tblDelivery.getRowCount(); i++) {

                String itemId = tblDelivery.getValueAt(i, 0).toString();
                String itemName = tblDelivery.getValueAt(i, 1).toString();
                String itemSize = tblDelivery.getValueAt(i, 2).toString();
                String itemPrice = tblDelivery.getValueAt(i, 3).toString();
                String itemQty = tblDelivery.getValueAt(i, 4).toString();

                tbl.addCell(itemId);
                tbl.addCell(itemName);
                tbl.addCell(itemSize);
                tbl.addCell(itemPrice);
                tbl.addCell(itemQty);

            }

            doc.add(tbl);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManageReportView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ManageReportView.class.getName()).log(Level.SEVERE, null, ex);
        }

        doc.close();

    }//GEN-LAST:event_btnItemActionPerformed

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
            java.util.logging.Logger.getLogger(ManageReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageReportView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageReportView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelivery;
    private javax.swing.JButton btnItem;
    private javax.swing.JButton btnMainMenu;
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblDelivery;
    private javax.swing.JTable tblItem;
    private javax.swing.JTable tblOrder;
    // End of variables declaration//GEN-END:variables
}
