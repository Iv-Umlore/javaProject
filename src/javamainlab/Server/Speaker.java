/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */
public class Speaker extends Thread{
    
    private Socket sock;
    private DataInputStream dis;        
    private DataOutputStream dos;       
    private String userName;
    private String command;
    
    private TreeChanges/*Interface*/ TreeCh;
    
    public Speaker (Socket s, String UName) throws IOException{
        sock = s;
        dis = new DataInputStream(sock.getInputStream());
        dos = new DataOutputStream(sock.getOutputStream());
        userName = UName;
        TreeCh = new TreeChanges(/*Way*/);
    }
    
    @Override
    public void run(){
        
        System.out.println("User " + userName + " is login!");
        //System.out.println(dis);
        //System.out.println(dos);
           
        
        
        TreeCh.start();
        while (true) {
        try {
            command = dis.readUTF();
            
            switch (command) {
                case "speed": {                    
                    TreeCh.ChangeGrowthSpeed(dis.read());
                    break;
                }
                case "destroy" : {
                    //TreeCh.DestroyBranch();
                    System.out.println(TreeCh.GetChange());// должен вернуть изменения.
                    break;
                }
                case "status" : {
                    dos.writeUTF(TreeCh.GetChange());
                    dos.flush();
                    break;
                }
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Speaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
        // The algorithm of interaction will be here
        
    }
    
    
}
