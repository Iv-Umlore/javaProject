/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javamainlab.Server.HashTable;
// Возможный выход во время завершения работы сервера. Оставим на будущее


/**
 *
 * @author Umlore
 */

    // Класс для перехвата новых подключаемых клиентов и для 
    // предоставления каждому собственного потока

public class Server  extends Thread {
    
    private ServerSocket ss;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String Login, pass , operation;
    
    HashTableInterface users;
    
    public Server(ServerSocket SeSo) throws IOException{
        ss = SeSo;
        users = new HashTable();
    }
    
    @Override
    public void run(){
        //System.out.println(this.getId());
        try {
            while (true) {
                socket = ss.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                
                operation = dis.readUTF();
                if (operation.equals("check")) {
                    Login = dis.readUTF();
                    pass = dis.readUTF();

                    System.out.println(Login + " " + pass);

                    dos.writeBoolean(users.CheckLogPas(Login, pass));
                    dos.flush();
                }
                
                if (operation.equals("registrate")) {
                    try {    
                    Login = dis.readUTF();
                    pass = dis.readUTF();                  
                    
                        dos.writeBoolean(users.Registration(Login, pass));
                        dos.flush();
                    } catch (IOException ex) {
                        try {
                            dos.writeBoolean(false);
                            dos.flush();
                        } catch (IOException ex1) {
                            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex1);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private HashTable HashTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
