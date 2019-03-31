/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dbutil.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pojo.ChatClient;

/**
 *
 * @author sasuke uchiha
 */
public class ChatClientDAO {
    private static Connection conn;
    private static PreparedStatement findClient;
    private static PreparedStatement addClient;
    
    public static boolean findClient(String userName)throws SQLException{
        conn=DBConnection.getConnection();
        findClient=conn.prepareStatement("select 1 from chatclients where username=?");
        ResultSet rs=findClient.executeQuery();
        findClient.setString(1, userName);
        return rs.next();
    }
    
    public static boolean addClient(ChatClient client)throws SQLException{
        boolean status=false;
        conn=DBConnection.getConnection();
        addClient=conn.prepareStatement("insert into chatclients values(?,?)");
        addClient.setString(1,client.getUserName());
        addClient.setString(2,client.getPassword());
        int ans=addClient.executeUpdate();
        if(ans!=0){
            status=true;
        }
        return status;
    }

}
