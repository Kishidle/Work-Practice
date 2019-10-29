/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ramon
 */
public class SQLConnection extends DatabaseFactory{
    
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://RAMON-PC\\SQLEXPRESS:49364;databaseName=testArca;integratedSecurity=true";
    
    public SQLConnection(){
        
    }
    
    @Override
    public Connection getConnection(){
        
        try{
            Class.forName(driver);
            
        }
        catch(ClassNotFoundException cnfe){
            
        }
        
        try{
            System.out.println("test");
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch(SQLException sqle){
            
        }
        return null;
    }
}
