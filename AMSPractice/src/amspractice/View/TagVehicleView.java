/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.View;

import amspractice.Controller.SQLConnection;
import amspractice.Model.Patron;
import amspractice.Model.Tag;
import amspractice.Model.Vehicle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramon
 */
public class TagVehicleView extends javax.swing.JFrame {

    /**
     * Creates new form AddTagView
     */
    
    private SQLConnection sqlCon;
    private ArrayList<Tag> tagList;
    private ArrayList<Patron> patronList;
    private ArrayList<Vehicle> vehicleList;
    public TagVehicleView() {
        initComponents();
        
        tagList = new ArrayList<>();
        vehicleList = new ArrayList<>();
        patronList = new ArrayList<>();
        sqlCon = new SQLConnection();
        carTable.getTableHeader().setReorderingAllowed(false);
        carTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        patronTable.getTableHeader().setReorderingAllowed(false);
        patronTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        populatePatronTable();
        //jTable2.getColumnModel().getColumn(1).setPreferredWidth(35);
        
        //TODO add functionality for tag adding and the add vehicle button + right click functionality for viewing of vehicles
    }
    public void populatePatronTable(){
        
        //TODO only query patrons with no tag yet
        
        /*String query = "SELECT * FROM Tags";
        try(Connection conn = sqlCon.getConnection();PreparedStatement stmt = conn.prepareStatement(query);){
            
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) tagTable.getModel();
            while(rs.next()){
                
                Tag tag = new Tag();
                tag.setTagID(rs.getInt("tag_id"));
                tag.setTagNumber(rs.getInt("tag_number"));
                tag.setTagStatus(rs.getString("tag_status"));
                tag.setVehicleID(rs.getInt("vehicle_id"));
                
                tagList.add(tag);
                model.addRow(new Object[]{(tag.getTagNumber())});
            }
        }
        catch(SQLException sqle){
            
        }*/
        
        String query = "SELECT * FROM Patrons";
        try(Connection conn = sqlCon.getConnection(); PreparedStatement stmt = conn.prepareStatement(query);){
            
            ResultSet rs = stmt.executeQuery();
            DefaultTableModel model = (DefaultTableModel) patronTable.getModel();
            while(rs.next()){
                
                Patron patron = new Patron();
                patron.setaccID(rs.getInt("patron_id"));
                patron.setAccountType(rs.getInt("account_type"));
                patron.setfName(rs.getString("first_name"));
                patron.setlName(rs.getString("last_name"));
                patron.setSex(rs.getString("sex"));
                patron.sethPhone(rs.getString("home_phone"));
                
                patronList.add(patron);
                
                model.addRow(new Object[]{patron.getaccID(), patron.getfName(), patron.getlName()});
            }
        }
        catch(SQLException sqle){
            
        }
        
        final JPopupMenu tagPopupMenu = new JPopupMenu();
        JMenuItem addVehicle = new JMenuItem("Add Tag to Patron");
        addVehicle.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                int index = patronTable.getSelectedRow();
                AddTagVehicleView atvv = new AddTagVehicleView(patronList.get(index));
                atvv.setVisible(true);
            }
            
        });
        
        tagPopupMenu.add(addVehicle);
        patronTable.setComponentPopupMenu(tagPopupMenu);
        
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
        jScrollPane2 = new javax.swing.JScrollPane();
        patronTable = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        carTable = new javax.swing.JTable();
        exitButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        patronTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patron ID", "First Name", "Last Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(patronTable);
        if (patronTable.getColumnModel().getColumnCount() > 0) {
            patronTable.getColumnModel().getColumn(0).setResizable(false);
            patronTable.getColumnModel().getColumn(1).setResizable(false);
            patronTable.getColumnModel().getColumn(2).setResizable(false);
        }

        carTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Plate Number", ""
            }
        ));
        jScrollPane1.setViewportView(carTable);
        if (carTable.getColumnModel().getColumnCount() > 0) {
            carTable.getColumnModel().getColumn(0).setResizable(false);
            carTable.getColumnModel().getColumn(1).setMinWidth(20);
            carTable.getColumnModel().getColumn(1).setPreferredWidth(20);
            carTable.getColumnModel().getColumn(1).setMaxWidth(20);
        }

        exitButton.setText("Exit");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tag Number"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(exitButton)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        // TODO add your handling code here:
        MainView mv = new MainView();
        mv.setVisible(true);
        dispose();
    }//GEN-LAST:event_exitButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TagVehicleView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TagVehicleView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable carTable;
    private javax.swing.JButton exitButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable patronTable;
    // End of variables declaration//GEN-END:variables
}