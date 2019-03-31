/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import pojo.ChatLog;

/**
 *
 * @author sasuke uchiha
 */
public class ChatLogsDAO {
    private static Connection conn;
    private static PreparedStatement addChat;
    
    public static boolean addChatLog(ChatLog chat)throws SQLException{
        boolean status = false;
        addChat=conn.prepareStatement("insert into chatlogs values(?,?,?)");
        addChat.setString(1, chat.getUserName());
        addChat.setString(2,chat.getMessage());
        addChat.setString(3,chat.getMsgTime());
        int ans=addChat.executeUpdate();
        if(ans!=0)
            status=true;
        return status;  
    }
    
}
