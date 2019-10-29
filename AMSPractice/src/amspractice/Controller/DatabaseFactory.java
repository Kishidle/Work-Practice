/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amspractice.Controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author Ramon
 */
public abstract class DatabaseFactory {
    
    public static DatabaseFactory getInstance(){
        return new SQLConnection();
    }
    
    public abstract Connection getConnection();
    
    public void closeConnection(Connection conn){
        
        try{
            conn.close();
        }
        catch(Exception e){
            
        }
    }
    
    public void closeResultSet(ResultSet rs){
        try{
            rs.close();
        }
        catch(Exception e){
            
        }
    }
    
    public void closeStatement(Statement stmt){
        try{
            stmt.close();
        }
        catch(Exception e){
            
        }
    }
}
