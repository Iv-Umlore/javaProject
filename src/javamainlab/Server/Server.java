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
    
    UserIdentificationInterface users;
    
    public Server(ServerSocket SeSo) throws IOException{
        ss = SeSo;
        users = new UserIdentification();
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
}
