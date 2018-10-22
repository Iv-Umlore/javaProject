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
    
    
    private Hashtable users;
    
    private Hashtable CreateHT() throws FileNotFoundException, IOException{
        Hashtable<String,String> HT = new Hashtable<String,String>();
        FileReader FR = new FileReader("src\\javamainlab\\Users\\Users.txt");
        int i = 0;
        while ((i = FR.read())!= -1){
            Login = "";
            pass = "";           
            
            while((char)i !=' '){
                Login = Login + (char)i;
                i = FR.read();                 
            }
            while (((char)(i = FR.read()) != '\r') && (i != -1))  {
                pass = pass + (char)i;                
            } 
            i = FR.read();
            //System.out.println(Login + " " + pass); 
            HT.put(Login, pass);
        }
        FR.close();
        
        for (Object key : HT.keySet()) {           
           System.out.println(key + " " +HT.get(key)); 
        }
        
        return HT;
    }
    
<<<<<<< HEAD
  /*  private void SaveHT() throws IOException{
        FileWriter FW = new FileWriter("src\\javamainlab\\Users\\Users2.txt");
        String Login = "";
        for (Object key : users.keySet()) {
           FW.write((String) key + " " + users.get(key) + '\n');
           System.out.println(key + " " +users.get(key)); 
        }
=======
    private void SaveHT() throws IOException{
        int i=1;
        FileWriter FW = new FileWriter("src\\javamainlab\\Users\\Users.txt");
        String Login = "";
        for (Object key : users.keySet()) {
           FW.write((String) key + " " + users.get(key) + '\r');
           if (i < users.size()){
               FW.write('\n');
               i++;
           }
        }        
>>>>>>> SecondB
        FW.write(-1);
        FW.close();
    }*/
    
    public Server(ServerSocket SeSo) throws IOException{
        ss = SeSo;
        users = CreateHT();
        //SaveHT();
    }
    
    @Override
    public void run(){
        //System.out.println(this.getId());
        try {
            while (true) {
                socket = ss.accept();
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
                Login = dis.readUTF();
                pass = dis.readUTF();
                
                System.out.println(Login + " " + pass);
                System.out.println(users.get(Login));
                
                if (pass.equals(users.get(Login))) {
                    dos.writeBoolean(true);
                    dos.flush();
                }
                else {
                    dos.writeBoolean(false);
                    dos.flush();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
