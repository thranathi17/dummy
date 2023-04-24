/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.LabJPanels;

import Business.Business;
import Lab.LabTechnician;
import Lab.Vaccination;
import Lab.VaccinationDirectory;
import Pharmacy.Pharmacy;
import UI.MainJFrame;
import UserAccount.UserAccount;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thran
 */
public class VaccineListJFrame extends javax.swing.JPanel {

    /**
     * Creates new form VaccineListJFrame
     */
    
    Business business;
    UserAccount useraccount;
    MainJFrame main;
    VaccinationDirectory vaccineDir;
    DefaultTableModel medicineTableModel;
    LabTechnician labTech;
    public VaccineListJFrame(Business business, UserAccount useraccount) {
        initComponents();
        this.business=business;
       this.useraccount=useraccount;
       this.medicineTableModel = (DefaultTableModel) vaccineJTable.getModel();
       
       this.setVisible(true);
       
       displayVaccine();
          
    }
    private void displayVaccine() {
        ArrayList<Vaccination> vaccine = this.business.getVaccineDir().getVaccinelist();
        
        if(vaccine.size() >= 0) {
            medicineTableModel.setRowCount(0);
            for(Vaccination v: vaccine) {
                Object row[] = new Object[4];
                row[0] = v.getVaccinationName();
                row[1] = v.getVaccinationID();
                row[2] = v.getDosage();
                row[3] = v.getPrice();
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
        vaccineJTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fVacName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fVacDosage = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fVacPrice = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vaccineJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Dosage", "Price"
            }
        ));
        jScrollPane1.setViewportView(vaccineJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, 90));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        jLabel2.setText("Vaccine Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));
        add(fVacName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 60, -1));

        jLabel3.setText("Dosage");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));
        add(fVacDosage, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 60, -1));

        jLabel4.setText("Price");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));
        add(fVacPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 60, -1));

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LabJFrame(business, useraccount);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
         
       String vaccinationName= fVacName.getText();
       int Dosage = Integer.parseInt(fVacDosage.getText());
    double Price = Double.parseDouble(fVacPrice.getText());

        
      
       String personId = this.useraccount.getPersonId();
       
       Vaccination v=this.business.getVaccineDir().createVaccination(vaccinationName, vaccinationName, Dosage, Price);
       displayVaccine();
        JOptionPane.showMessageDialog(this, "Medicine Added");
        
        }
        
        catch(HeadlessException| NumberFormatException ex){
            JOptionPane.showMessageDialog(this, "Please check data");
        }


      // fserailNum.setText("");
       fVacName.setText(""); 
       fVacDosage.setText("");
       fVacPrice.setText("");
       
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fVacDosage;
    private javax.swing.JTextField fVacName;
    private javax.swing.JTextField fVacPrice;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable vaccineJTable;
    // End of variables declaration//GEN-END:variables
}
