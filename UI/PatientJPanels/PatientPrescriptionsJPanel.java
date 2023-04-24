/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.PatientJPanels;

import Business.Business;
import Hospital.Appointment;
import Insurance.InsurancePlans;
import Patient.Patient;
import Pharmacy.Medicine;
import Prescription.Prescription;
import UserAccount.UserAccount;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MC
 */
public class PatientPrescriptionsJPanel extends javax.swing.JPanel {

    public Business business;
    public UserAccount userAccount;
    DefaultTableModel prescTableModel;
    
    public PatientPrescriptionsJPanel() {
        initComponents();
    }
    
    public PatientPrescriptionsJPanel(Business business, UserAccount userAccount) {
        initComponents();
        this.business = business;
        this.userAccount = userAccount;
        this.prescTableModel = (DefaultTableModel) patPrescriptionsTable.getModel();
        
        displayPrescriptions();
    }
    
    public void displayPrescriptions()
    {
        ArrayList<Prescription> ps = this.business.getPrescriptions().getPrescriptions();
        if(ps.size() >= 0) {
            prescTableModel.setRowCount(0);
            for(Prescription p: ps) {
                if (p.getPatient().getId().equals(userAccount.getPersonId()))
                {
                    Object row[] = new Object[8];
                    row[0] = p.getDoctor().getFirstName() + ' ' + p.getDoctor().getLastName();
                    row[1] = p.getPatient().getFirstName() + ' ' + p.getPatient().getLastName();
                    row[2] = p.getMedicine().getMedicineName();
                    row[3] = p.getQuantity();
                    row[4] = p.getStatus();
                    row[5] = p.getMedicine().getPrice() * p.getQuantity();
                    if (p.getPatient().getInsurancePlan() != null)
                    {
                        InsurancePlans ip = p.getPatient().getInsurancePlan();
                        Float coverage = ip.getCoveragePercentage();

                        row[6] = (p.getMedicine().getPrice() * p.getQuantity()) * coverage;
                        row[7] = (p.getMedicine().getPrice() * p.getQuantity()) - ((p.getMedicine().getPrice() * p.getQuantity()) * coverage);

                    }
                    else{
                        row[6] = 0.00;
                        row[7] =  p.getMedicine().getPrice() * p.getQuantity();
                    }
                    prescTableModel.addRow(row);
                } 
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
        patPrescriptionsTable = new javax.swing.JTable();

        patPrescriptionsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor", "Patient", "Medicine", "Quantity", "Status", "Total Cost", "Paid by Ins", "Paid by Patient"
            }
        ));
        jScrollPane1.setViewportView(patPrescriptionsTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1056, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(391, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable patPrescriptionsTable;
    // End of variables declaration//GEN-END:variables
}