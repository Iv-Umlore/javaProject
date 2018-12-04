/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
// Возможный выход во время завершения работы сервера. Оставим на будущее


/**
 *
 * @author Umlore
 */

    // Класс для перехвата новых подключаемых клиентов и для 
    // предоставления каждому собственного потока

public class Server extends Thread {
    
    private ServerSocket ss;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String Login, pass , operation;
    
    boolean IsLogin;
    
    UserIdentificationInterface users;
          
    Speaker speak;
    
    public Server(ServerSocket SeSo) throws IOException{
        ss = SeSo;
        users = new UserIdentification();
        IsLogin = false;
    }
    
    @Override
    public void run(){
        try {
            while (true) {
                socket = ss.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                
                operation = dis.readUTF();
                if (operation.equals("check")) {
                    Login = dis.readUTF();
                    pass = dis.readUTF();
                    
                    IsLogin = users.CheckLogPas(Login, pass);
                    
                    dos.writeBoolean(IsLogin);
                    dos.flush();
                    
                    if (IsLogin) {           // передаём общение другому классу
                        speak = new Speaker(socket,Login);
                        speak.run();
                    }
                    IsLogin = false;
                }
                
                if (operation.equals("registrate")) {
                    try {    
                    Login = dis.readUTF();
                    pass = dis.readUTF();                  
                    
                    dos.writeBoolean(users.Registration(Login, pass));
                    dos.flush();
                    
                    TreeChangesInterface TCI = new TreeChanges();
                    TCI.SaveTree();
                    
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
}
