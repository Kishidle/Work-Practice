/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.View;

import amspractice.Controller.SQLConnection;
import amspractice.Model.Patron;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ramon
 */
public class ViewPatronView extends javax.swing.JFrame {

    /**
     * Creates new form ViewPatronView
     */
    
    private ArrayList<Patron> patronList;
    private SQLConnection sqlCon;
    public ViewPatronView() {
        initComponents();
        sqlCon = new SQLConnection();
        this.setTitle("View Patron(s)");
        patronList = new ArrayList<>();
        
        initTable();
        
        accountTypeComboBox.addItemListener(new ItemListener(){
            
            public void itemStateChanged(ItemEvent e){
                if(e.getStateChange() == ItemEvent.SELECTED){
                    Object source = e.getSource();
                    if(source instanceof JComboBox){
                        JComboBox cb = (JComboBox) source;
                        
                        fNameTextField.setText("");
                        lNameTextField.setText("");
                        sexTextField.setText("");
                        hPhoneTextField.setText("");
                        
                        int selectedIndex = cb.getSelectedIndex();
                        String sql = "";
                        //TODO just concat the account type
                        switch(selectedIndex){
                            case 0: 
                                sql = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons"; break;
                            case 1: 
                                sql = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons WHERE account_type = 1"; break;
                            case 2: 
                                sql = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons WHERE account_type = 2"; break;
                            case 3: 
                                sql = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons WHERE account_type = 3"; break;
                            case 4: 
                                sql = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons WHERE account_type = 4"; break;
                            case 5: 
                                sql = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons WHERE account_type = 5"; break;
                        }
                        
                        
                        
                        
                        try(Connection conn = sqlCon.getConnection(); Statement stmt = conn.createStatement();){
                            ResultSet rs = stmt.executeQuery(sql);
                            
                            DefaultTableModel model = (DefaultTableModel) patronTable.getModel();
                            model.setRowCount(0);
                            patronList.clear();
                            while(rs.next()){
                                Patron patron = new Patron();
                                patron.setaccID(rs.getInt("patron_id"));
                                patron.setAccountType(rs.getInt("account_type"));
                                patron.setfName(rs.getString("first_name"));
                                patron.setlName(rs.getString("last_name"));
                                patron.setSex(rs.getString("sex"));
                                patron.sethPhone(rs.getString("home_phone"));
                                patronList.add(patron);
                                
                                model.addRow(new Object[]{patron.getAccountType(), patron.getfName(), patron.getlName(), patron.getSex(), patron.gethPhone()});
                            }
                        }
                        catch(SQLException se){
                            
                        }
                        
                        
                    }
                }
            }
        });
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        patronTable = new javax.swing.JTable();
        backButton = new javax.swing.JButton();
        accountTypeComboBox = new javax.swing.JComboBox<>();
        fNameTextField = new javax.swing.JTextField();
        lNameTextField = new javax.swing.JTextField();
        sexTextField = new javax.swing.JTextField();
        hPhoneTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Account Type:");

        jLabel2.setText("First Name:");

        jLabel3.setText("Last Name:");

        jLabel4.setText("Sex:");

        jLabel5.setText("Home Phone:");

        patronTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Account Type", "First Name", "Last Name", "Sex", "Home Phone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(patronTable);
        if (patronTable.getColumnModel().getColumnCount() > 0) {
            patronTable.getColumnModel().getColumn(0).setResizable(false);
            patronTable.getColumnModel().getColumn(1).setResizable(false);
            patronTable.getColumnModel().getColumn(2).setResizable(false);
        }

        backButton.setText("Go back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        accountTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Any", "1 - Corporate Revenue", "2 - Individual Non-Revenue", "3 - Individual Revenue", "4 - Corporate Individual Revenue", "5 - Corporate Non-Rev" }));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(accountTypeComboBox, 0, 181, Short.MAX_VALUE)
                            .addComponent(fNameTextField)
                            .addComponent(lNameTextField))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hPhoneTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(sexTextField))
                        .addGap(76, 76, 76)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backButton)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(accountTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(fNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(lNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton)
                    .addComponent(searchButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        MainView mv = new MainView();
        mv.setVisible(true);
        dispose();
    }//GEN-LAST:event_backButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        // TODO add your handling code here:
        // TODO get patron_id in select statement for use in add tag and add vehicle view and right click functionality of view patron
        
        patronList.clear(); 
        String fName = "", lName = "", sex = "", hPhone = ""; 
        String searchSQL = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons ";
        switch(accountTypeComboBox.getSelectedIndex()){
            case 1: 
                searchSQL = searchSQL.concat("WHERE account_type = 1"); 
                break;
            case 2:
                searchSQL = searchSQL.concat("WHERE account_type = 2");
                break;
            case 3:
                searchSQL = searchSQL.concat("WHERE account_type = 3");
                break;
            case 4:
                searchSQL = searchSQL.concat("WHERE account_type = 4");
                break;
            case 5:
                searchSQL = searchSQL.concat("WHERE account_type = 5");
                break;
        }
        if(accountTypeComboBox.getSelectedIndex() != 0){
            searchSQL = searchSQL.concat(" AND ");
        }
        else{
            searchSQL = searchSQL.concat("WHERE ");
        }
        
        fName = fNameTextField.getText();
        lName = lNameTextField.getText();
        sex = sexTextField.getText();
        hPhone = hPhoneTextField.getText();
        
        searchSQL = searchSQL.concat("first_name LIKE '" + fName + "%' AND last_name LIKE '" + lName + "%' AND sex LIKE '" + sex + "%' AND home_phone LIKE '" + hPhone + "%'");
        
        System.out.println("searchSQL test");
        System.out.println(searchSQL);
        
       
        try(Connection conn = sqlCon.getConnection(); Statement stmt = conn.createStatement();){
            ResultSet rs = stmt.executeQuery(searchSQL);
            DefaultTableModel model = (DefaultTableModel) patronTable.getModel();
                model.setRowCount(0);
                while(rs.next()){
                    //TODO add to Patron class to get the account id later
                    Patron patron = new Patron();
                    patron.setaccID(rs.getInt("patron_id"));
                    patron.setAccountType(rs.getInt("account_type"));
                    patron.setfName(rs.getString("first_name"));
                    patron.setlName(rs.getString("last_name"));
                    patron.setSex(rs.getString("sex"));
                    patron.sethPhone(rs.getString("home_phone"));
                    /*int accType = rs.getInt("account_type");
                    fName = rs.getString("first_name");
                    lName = rs.getString("last_name");
                    sex = rs.getString("sex");
                    hPhone = rs.getString("home_phone");*/
                    System.out.println(patron.getfName());
                    patronList.add(patron);
                    model.addRow(new Object[]{patron.getAccountType(), patron.getfName(), patron.getlName(), patron.getSex(), patron.gethPhone()});
                }
        }
        catch(SQLException sqle){
            
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public void initTable(){
        
        patronTable.getTableHeader().setReorderingAllowed(false);
        patronTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        try(Connection conn = sqlCon.getConnection(); Statement stmt = conn.createStatement();){
            //String SQL = "INSERT INTO Patrons VALUES(" + np.getAccountType() + ", '" + np.getfName() + "', '" + np.getlName() + "', '" + np.getSex() + "', '" + np.gethPhone() + "')";
            //String SQL = "SELECT * FROM Patrons";
            String SQL = "SELECT patron_id, account_type, first_name, last_name, sex, home_phone FROM Patrons";
            ResultSet rs = stmt.executeQuery(SQL);
            
            DefaultTableModel model = (DefaultTableModel) patronTable.getModel();
            while(rs.next()){
                Patron patron = new Patron();
                patron.setaccID(rs.getInt("patron_id"));
                patron.setAccountType(rs.getInt("account_type"));
                patron.setfName(rs.getString("first_name"));
                patron.setlName(rs.getString("last_name"));
                patron.setSex(rs.getString("sex"));
                patron.sethPhone(rs.getString("home_phone"));
                /*int accType = rs.getInt("account_type");
                String fName = rs.getString("first_name");
                String lName = rs.getString("last_name");
                String sex = rs.getString("sex");
                String hPhone = rs.getString("home_phone");*/
                patronList.add(patron);
                model.addRow(new Object[]{patron.getAccountType(), patron.getfName(), patron.getlName(), patron.getSex(), patron.gethPhone()});
            }
            //int x = stmt.executeUpdate(SQL);
            int x = 1;
            if(x > 0){
                System.out.print("Patron registered successfully");
            }
            else{
                System.out.print("Patron not registered");
            }
            
            System.out.println("x");
            
            
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem editPatron = new JMenuItem("Edit Patron");
        editPatron.addActionListener(new ActionListener(){
           
            @Override
            public void actionPerformed(ActionEvent e){
                int index = patronTable.getSelectedRow();
                EditPatronView epv = new EditPatronView(patronList.get(index));
                epv.setVisible(true);
                dispose();
            }
        });
        popupMenu.add(editPatron);
        JMenuItem addTag = new JMenuItem("Add Tag to Patron");
        patronTable.setComponentPopupMenu(popupMenu);
        
    }
    
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
            java.util.logging.Logger.getLogger(ViewPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewPatronView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewPatronView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> accountTypeComboBox;
    private javax.swing.JButton backButton;
    private javax.swing.JTextField fNameTextField;
    private javax.swing.JTextField hPhoneTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lNameTextField;
    private javax.swing.JTable patronTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField sexTextField;
    // End of variables declaration//GEN-END:variables
}
