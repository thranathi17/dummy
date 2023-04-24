/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.PharmacyJPanels;

import Business.Business;
import Pharmacy.MedicineDirectory;
import Pharmacy.Pharmacy;
import Pharmacy.Medicine;
import UI.MainJFrame;
import UserAccount.UserAccount;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thran
 */
public class AddMedicine extends javax.swing.JPanel {

    /**
     * Creates new form AddMedicine
     */
    Business business;
    UserAccount useraccount;
    MainJFrame main;
    MedicineDirectory medicinedir;
    DefaultTableModel medicineTableModel;
    Pharmacy Pharmacist;
    public AddMedicine(Business business, UserAccount useraccount) {
        initComponents();
        this.business=business;
       this.useraccount=useraccount;
       this.medicineTableModel = (DefaultTableModel) medicineJTable.getModel();
       
       this.setVisible(true);
       
       displayMedicine();
          
    }
    private void displayMedicine() {
        ArrayList<Medicine> medicine = this.business.getMedicineDir().getMedicineList();
        
        if(medicine.size() >= 0) {
            medicineTableModel.setRowCount(0);
            for(Medicine m: medicine) {
                Object row[] = new Object[6];
                row[0] = m.getSerialNumber();
                row[1] = m.getMedicineName();
                row[2] = m.getExpiryDate();
                row[3] = m.isIsAvailable();
                row[4] = m.getAvailableCount();
                row[5] = m.getPrice();
                medicineTableModel.addRow(row);
            }
        }
        
        
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
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fMedicineName = new javax.swing.JTextField();
        fAvCount = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        medicineJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fPrice = new javax.swing.JTextField();
        fExpDate = new com.toedter.calendar.JDateChooser();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setBackground(new java.awt.Color(255, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Medicine Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel3.setText("Expiry Date");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel4.setText("is Available");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel5.setText("Available Count");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        add(fMedicineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 80, -1));
        add(fAvCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 80, -1));
        add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, -1, -1));

        medicineJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "S.No", "Medicine Name", "Expiry Dt", "Is Available", "Available Count", "Price perStrip"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(medicineJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 460, 150));

        jButton1.setText("Add Medicine");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, -1, -1));

        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jLabel6.setText("Price per Strip");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));
        add(fPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 80, -1));
        add(fExpDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 80, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
         
       String medicineName= fMedicineName.getText();
       Date regDate= fExpDate.getDate();
        boolean isAvailable = jCheckBox1.isSelected();
       int numCount = Integer.parseInt(fAvCount.getText());
    float price = Float.parseFloat(fPrice.getText());

        
      
       String personId = this.useraccount.getPersonId();
       
       Medicine m= this.business.getMedicineDir().createMedicine( medicineName,regDate, isAvailable,numCount,price );
       displayMedicine();
        JOptionPane.showMessageDialog(this, "Medicine Added");
        
        }
        
        catch(HeadlessException| NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please check data");
        }


      // fserailNum.setText("");
       fMedicineName.setText(""); 
       fExpDate.setDate(null);
       jCheckBox1.setText("");
       fAvCount.setText("");
      fPrice.setText("");
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new PharmacistJFrame(business, useraccount);
    }//GEN-LAST:event_backBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField fAvCount;
    private com.toedter.calendar.JDateChooser fExpDate;
    private javax.swing.JTextField fMedicineName;
    private javax.swing.JTextField fPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable medicineJTable;
    // End of variables declaration//GEN-END:variables
}
