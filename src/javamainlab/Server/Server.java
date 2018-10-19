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

public class Server  extends Thread {
    
    private ServerSocket ss;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private String Login, pass;
    
    
    public Server(ServerSocket SeSo){
        ss = SeSo;
    }
    
    @Override
    public void run(){
        System.out.print(this.getId());
       /* try {
            while (true) {
                socket = ss.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                Login = dis.readUTF();
                pass = dis.readUTF();
                
                System.out.println(Login + " " + pass);
                if ((Login == "admin") && (pass == "admin")) dos.writeBoolean(true);
                else dos.writeBoolean(false);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
}
