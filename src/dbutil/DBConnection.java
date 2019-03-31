/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author sasuke uchiha
 */
public class DBConnection {
    private static Connection conn;
    static{
        try{
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-OE7AC3H:1521/XE", "rohit", "sasuke007");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public static Connection getConnection(){
        return conn;
    }
    
    
    public static void close(){
        
    }
}
