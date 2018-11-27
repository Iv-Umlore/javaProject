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
    
    private TreeChangesInterface TreeCh;
    
    public Speaker (Socket s, String UName) throws IOException{
        sock = s;
        dis = new DataInputStream(sock.getInputStream());
        dos = new DataOutputStream(sock.getOutputStream());
        userName = UName;
        TreeCh = new TreeChanges(/*Way*/);
    }
    
    @Override
    public void run(){
        
        System.out.print("User " + userName + " is login!");
        TreeCh.run();
        while (true) {
        try {
            command = dis.readUTF();
            
            System.out.println ( command );
            
            switch (command) {
                case "speed": {                    
                    TreeCh.ChangeGrowthSpeed(dis.read());
                    break;
                }
                case "destroy" : {
                    TreeCh.DestroyBranch();
                    // должен вернуть изменения.
                    break;
                }
                case "status" : {
                    dos.writeInt(TreeCh.GetChange());
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
