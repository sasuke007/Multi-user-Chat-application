/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multiuserchatapplication;

import dao.ChatClientDAO;
import dao.ChatLogsDAO;
import java.awt.List;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import pojo.ChatClient;
import pojo.ChatLog;

/**
 *
 * @author sasuke uchiha
 */
public class ServerModule extends javax.swing.JFrame {

    /**
     * Creates new form ServerModule
     */
    
    
       ServerSocket svc;
      ArrayList<String> usersNames=new ArrayList<>();
      ArrayList<PrintWriter> usersMessage=new ArrayList<>();
      FileWriter fw;
      PrintWriter fpw;
      SimpleDateFormat sdf;
     
    public ServerModule() {
        initComponents();
        try{
            fw=new FileWriter("d:\\chatlogs.txt",true);
            fpw=new PrintWriter(fw,true);
            sdf=new SimpleDateFormat("HH:mm:ss,dd-MM-yyyy");
        }
        catch(IOException ex){
            ex.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChat = new javax.swing.JTextArea();
        name = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        start = new javax.swing.JButton();
        stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        txtChat.setColumns(20);
        txtChat.setRows(5);
        jScrollPane1.setViewportView(txtChat);

        name.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setText("TWO WAY CHAT APP");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Server Module");

        start.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        start.setText("Start Server");
        start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startActionPerformed(evt);
            }
        });

        stop.setText("Stop Server");
        stop.setEnabled(false);
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(127, 127, 127))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(start, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
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

    private void startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startActionPerformed
           
        try{
                 svc=new ServerSocket(4040);
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
            start.setEnabled(false);
            stop.setEnabled(true);
            WaitForConnectionThread wt=new WaitForConnectionThread();
            wt.start();
            txtChat.append("Server is Running");
    }//GEN-LAST:event_startActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
            try{
                svc.close();
                System.exit(0);
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
    }//GEN-LAST:event_stopActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try{
        fw.close();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerModule.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerModule().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JButton start;
    private javax.swing.JButton stop;
    private javax.swing.JTextArea txtChat;
    // End of variables declaration//GEN-END:variables
    
    
    class ChatThread extends Thread{
        PrintWriter pw;
        Scanner sc;
        Socket socket;
      
        
        ChatThread(Socket socket){
            try{
                this.socket=socket;
                pw=new PrintWriter(socket.getOutputStream(),true);
                sc=new Scanner(socket.getInputStream());
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
        
        @Override
        public void run(){
            pw.println("NAMEREQUIRED");
            String name=sc.nextLine();
//            System.out.println(name);
//            while(usersNames.contains(name)){
//                pw.println("NAMEALREADYPRESENT");
//                name=sc.nextLine();
//            }
               while(true){
                    try{
                     if(ChatClientDAO.findClient(name)==false){
                         break;
                     }
                     else{
                         pw.println("NAMEALREADYPRESENT");
                         name=sc.nextLine();
                     }
                  }
                    catch(SQLException ex){
                            pw.println("NAMEALREADYPRESENT");
                            name=sc.nextLine();
                            System.out.println("Error in Connecting from database");
                     }
               }
            pw.println("NAMEACCEPTED");
            try{
            usersNames.add(name);
            usersMessage.add(pw);
            txtChat.append("\nConnected to the client :" + name + " with IP "+socket.getLocalAddress());
            ChatClient client = new ChatClient(name,socket.getLocalAddress().toString());
            boolean ans=ChatClientDAO.addClient(client);
            if(ans){
                System.out.println("Recond Successfully Inserted");
            }
            else{
                
            }
            }
            catch(SQLException ex){
                System.out.println("Error in connecting from DB");
            }
            while(true){
                String msg=sc.nextLine();
                if(msg.equalsIgnoreCase("quit")){
                    pw.println("quit");
                    try{
                    socket.close();
                    }
                    catch(IOException ex){
                        ex.printStackTrace();
                    }
                    break;
                }
                synchronized(fpw){
                    String timestamp=sdf.format(new Date());
                    fpw.println(name+":"+msg+"("+timestamp+")");
                    ChatLog ch=new ChatLog();
                    ch.setMessage(msg);
                    ch.setMsgTime(timestamp);
                    ch.setUserName(name);
                    try{
                        boolean result=ChatLogsDAO.addChatLog(ch);
                        if(result){
                            System.out.println("Message added successfully");
                        }
                        else{
                            System.out.println("Error in writing to the database");
                        }
                    }
                    catch(SQLException ex){
                        ex.printStackTrace();
                    }
                }
                Iterator it1=usersNames.iterator();
                Iterator it2=usersMessage.iterator();
                while(it1.hasNext()){
                    String user;
                    user = (String)it1.next();
                    if(user.equals(name)){
                        it2.next();
                    }
                    else{
                        PrintWriter x=(PrintWriter)it2.next();
                        x.println(name+" : "+msg);
                    }
                }
            }
        }
    }
    
    
    
   class WaitForConnectionThread extends Thread{
        Socket socket;
        @Override
        public void run(){
                while(true){
                     try{
                        socket=svc.accept();
                        ChatThread ch=new ChatThread(socket);
                        ch.start();
                     }
                     catch(IOException ex){
                         ex.printStackTrace();
                    }
                }
            }
            
        }
    }
