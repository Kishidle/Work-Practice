/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.View;

import amspractice.Controller.SQLConnection;
import amspractice.Model.Patron;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Ramon
 */
public class AddPatronView extends javax.swing.JFrame {

    /**
     * Creates new form AddPatronView
     */
    private SQLConnection sqlCon;
    private String fName, lName, sex, hPhone;
    private int accountType;
    
    public AddPatronView() {
        initComponents();
        setLocationRelativeTo(null);
        sqlCon = new SQLConnection();
        this.setTitle("Add Patron");
        
        initializeComboBox();
    }
    
    public void initializeComboBox(){
        
        /*typeComboBox.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent e){
                
                if(e.getStateChange() == ItemEvent.SELECTED){
                    Object source = e.getSource();
                    if(source instanceof JComboBox){
                        JComboBox cb = (JComboBox)source;
                        int selectedIndex = cb.getSelectedIndex();
                        //dimming of textfields
                        //TODO add company name instead of first name last name
                        switch(selectedIndex){
                            case 0: 
                                sexComboBox.setEditable(false); 
                                hPhoneTextField.setEditable(true); break;
                            case 1: 
                                sexComboBox.setEditable(true);
                                hPhoneTextField.setEditable(false); break;
                            case 2: 
                                sexComboBox.setEditable(false); 
                                hPhoneTextField.setEditable(false); break;
                            case 3: break;
                            case 4: break;
                        }
                    }
                }
            }
        });*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        accouuntTypeLabel = new javax.swing.JLabel();
        typeComboBox = new javax.swing.JComboBox<>();
        fNameLabel = new javax.swing.JLabel();
        fNameTextField = new javax.swing.JTextField();
        lNameLabel = new javax.swing.JLabel();
        laNameTextField = new javax.swing.JTextField();
        sexLabel = new javax.swing.JLabel();
        hPhoneLabel = new javax.swing.JLabel();
        hPhoneTextField = new javax.swing.JTextField();
        sexComboBox = new javax.swing.JComboBox<>();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        accouuntTypeLabel.setText("Account Type");
        accouuntTypeLabel.setToolTipText("");

        typeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 - Corporate Revenue", "2 - Individual Non-Revenue", "3 - Individual Revenue", "4 - Corporate Individual Revenue", "5 - Corporate Non-Rev" }));

        fNameLabel.setText("First Name");

        lNameLabel.setText("Last Name");

        sexLabel.setText("Sex");

        hPhoneLabel.setText("Home Phone");

        hPhoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hPhoneTextFieldActionPerformed(evt);
            }
        });

        sexComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Others" }));
        sexComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sexComboBoxActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fNameLabel)
                            .addComponent(lNameLabel)
                            .addComponent(sexLabel)
                            .addComponent(hPhoneLabel))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hPhoneTextField)
                            .addComponent(laNameTextField)
                            .addComponent(fNameTextField)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(accouuntTypeLabel)
                        .addGap(18, 18, 18)
                        .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(85, 85, 85))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accouuntTypeLabel)
                    .addComponent(typeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lNameLabel)
                    .addComponent(laNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexLabel)
                    .addComponent(sexComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hPhoneLabel)
                    .addComponent(hPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton)
                    .addComponent(cancelButton))
                .addContainerGap(32, Short.MAX_VALUE))
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

    private void sexComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sexComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sexComboBoxActionPerformed

    private void hPhoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hPhoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hPhoneTextFieldActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
        
        MainView mv = new MainView();
        mv.setVisible(true);
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        // TODO add your handling code here:
        Patron np = new Patron();
        switch(typeComboBox.getSelectedIndex()){
            case 0: np.setAccountType(1); break;
            case 1: np.setAccountType(2); break;
            case 2: np.setAccountType(3); break;
            case 3: np.setAccountType(4); break;
            case 4: np.setAccountType(5); break;
        }
        np.setfName(fNameTextField.getText());
        np.setlName(laNameTextField.getText());
        np.sethPhone(hPhoneTextField.getText());
        np.setSex(sexComboBox.getSelectedItem().toString());
        
        System.out.println(np.getfName() + " " + np.getlName());
        
        try(Connection conn = sqlCon.getConnection(); Statement stmt = conn.createStatement();){
            String SQL = "INSERT INTO Patrons (account_type, first_name, last_name, sex, home_phone) VALUES(" + np.getAccountType() + ", '" + np.getfName() + "', '" + np.getlName() + "', '" + np.getSex() + "', '" + np.gethPhone() + "')";
            //String SQL = "SELECT * FROM Patrons";
            /*ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                System.out.println(rs.getString("first_name"));
            }*/
            int x = stmt.executeUpdate(SQL);
            //int x = 1;
            if(x > 0){
                System.out.print("Patron registered successfully");
                JOptionPane.showMessageDialog(null, "Patron registered successfully.");
            }
            else{
                System.out.print("Patron not registered");
                JOptionPane.showMessageDialog(null, "Patron not registered.");
                
            }
            
            System.out.println("x");
            
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        fNameTextField.setText("");
        laNameTextField.setText("");
        hPhoneTextField.setText("");
        typeComboBox.setSelectedIndex(0);
        
        
    }//GEN-LAST:event_okButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AddPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddPatronView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accouuntTypeLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel fNameLabel;
    private javax.swing.JTextField fNameTextField;
    private javax.swing.JLabel hPhoneLabel;
    private javax.swing.JTextField hPhoneTextField;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lNameLabel;
    private javax.swing.JTextField laNameTextField;
    private javax.swing.JButton okButton;
    private javax.swing.JComboBox<String> sexComboBox;
    private javax.swing.JLabel sexLabel;
    private javax.swing.JComboBox<String> typeComboBox;
    // End of variables declaration//GEN-END:variables
}
