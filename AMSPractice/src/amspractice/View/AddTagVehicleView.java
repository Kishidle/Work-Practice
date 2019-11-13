/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.View;

import amspractice.Controller.SQLConnection;
import amspractice.Model.Patron;
import amspractice.Model.Tag;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramon
 */
public class AddTagVehicleView extends javax.swing.JFrame {

    /**
     * Creates new form AddVehicle
     */
    private Patron patron;
    private SQLConnection sqlConn;
    private boolean hasTag;
    private Tag tag;
    private int vehicleID;
    //private ArrayList<Tag> tagList;
    
    
    public AddTagVehicleView(Patron patron){
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Add Tag and Vehicle");
        this.patron = patron;
        
        sqlConn = new SQLConnection();
        //tagList = new ArrayList<>();
        patronLabel.setText(patron.getfName() + " " + patron.getlName());
        
    }
    public AddTagVehicleView(){
        initComponents();
        //patronLabel.setText(patron.getfName() + " " + patron.getlName());
    }
    
    
    public Tag checkTagNumberExists(){
        hasTag = false;
        int tagNum = Integer.parseInt(tagNumberTextField.getText());
        String query = "SELECT tag_id, tag_number, tag_status FROM Tags WHERE tag_number = ?";
        
        try(Connection conn = sqlConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
            stmt.setInt(1, tagNum);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                hasTag = true;
                if(rs.getString("tag_status").equals("NOT_ASSIGNED")){
                    JOptionPane.showMessageDialog(null, "Tag is available.");
                    tag = new Tag();
                    tag.setTagID(rs.getInt("tag_id"));
                    tag.setTagNumber(rs.getInt("tag_number"));
                    tag.setTagStatus(rs.getString("tag_status"));
                    rs.close();
                    return tag;
                    /*
                    int confirm = JOptionPane.showConfirmDialog(null, "Would you like to use this tag?");
                    if(confirm == JOptionPane.YES_OPTION){
                        tagNumberTextField.setEditable(false);
                    }
                    else{
                        tagNumberTextField.setText("");
                    }*/
                }
                else{
                    JOptionPane.showMessageDialog(null, "Tag is already in use.");
                    tagNumberTextField.setText("");
                    return null;
                }
                
            }
            if(!hasTag){
                JOptionPane.showMessageDialog(null, "Tag does not exist");
                tagNumberTextField.setText("");
                return null;
            }
            
        }
        catch(SQLException sqle){
            
        }
        
        return null;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        plateNumberTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        makeTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        modelTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        yearTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        colorTextField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        tagNumberTextField = new javax.swing.JTextField();
        patronLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Tag Number:");

        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Plate Number:");

        jLabel3.setText("Make:");

        jLabel4.setText("Model:");

        modelTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelTextFieldActionPerformed(evt);
            }
        });

        jLabel5.setText("Year:");

        jLabel6.setText("Color:");

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        tagNumberTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tagNumberTextFieldActionPerformed(evt);
            }
        });

        patronLabel.setText("jLabel7");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(58, 58, 58)
                        .addComponent(colorTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(11, 11, 11)
                        .addComponent(plateNumberTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(57, 57, 57)
                        .addComponent(makeTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(modelTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(62, 62, 62)
                        .addComponent(yearTextField))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patronLabel)
                            .addComponent(jLabel1))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cancelButton))
                            .addComponent(tagNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(patronLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tagNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(plateNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(makeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(modelTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(yearTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(colorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton)
                    .addComponent(cancelButton))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        // get tag number from database
        if(checkTagNumberExists() != null){
            String plateNum = plateNumberTextField.getText();
            String carMake = makeTextField.getText();
            String carModel = modelTextField.getText();
            String carYear = yearTextField.getText();
            String carColor = colorTextField.getText();
            //int tagNum = Integer.parseInt(tagNumberTextField.getText());
            
            String query = "INSERT INTO Vehicles VALUES(?, ?, ?, ?, ?, ?)";
            try(Connection conn = sqlConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
                stmt.setInt(1, tag.getTagID());
                stmt.setString(2, plateNum);
                stmt.setString(3, carMake);
                stmt.setString(4, carModel);
                stmt.setString(5, carYear);
                stmt.setString(6, carColor);
                stmt.executeUpdate();
                
                
            }
            catch(SQLException sqle){
                
            }
            query = "SELECT vehicle_id, car_make FROM Vehicles WHERE tag_id = ?";
            try(Connection conn = sqlConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
                stmt.setInt(1, tag.getTagID());
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    vehicleID = rs.getInt("vehicle_id");
                    System.out.println(rs.getString("car_make"));
                }
            }
            catch(SQLException sqle){
                
            }
            query = "UPDATE Tags SET vehicle_id = ?, tag_status = ? WHERE tag_id = ?";
            try(Connection conn = sqlConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
                stmt.setInt(1, vehicleID);
                stmt.setString(2, "ASSIGNED");
                stmt.setInt(3, tag.getTagID());
                stmt.executeUpdate();
            }
            catch(SQLException sqle){
                
            }
            query = "UPDATE Patrons SET vehicle_id = ? WHERE patron_id = ?";
            try(Connection conn = sqlConn.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
                stmt.setInt(1, vehicleID);
                stmt.setInt(2, patron.getaccID());
                stmt.executeUpdate();
            }
            catch(SQLException sqle){
                
            }
            
            TagVehicleView tvv = new TagVehicleView();
            tvv.setVisible(true);
            dispose();
        }
        else{
            
        }
        
    }//GEN-LAST:event_saveButtonActionPerformed

    private void modelTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelTextFieldActionPerformed

    private void tagNumberTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tagNumberTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tagNumberTextFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        TagVehicleView tvv = new TagVehicleView();
        tvv.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddTagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTagVehicleView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField colorTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField makeTextField;
    private javax.swing.JTextField modelTextField;
    private javax.swing.JLabel patronLabel;
    private javax.swing.JTextField plateNumberTextField;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField tagNumberTextField;
    private javax.swing.JTextField yearTextField;
    // End of variables declaration//GEN-END:variables
}
