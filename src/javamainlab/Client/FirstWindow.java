/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */
public class FirstWindow implements FirstWindowInterface {
    
    @Override
    public boolean Registration(String Login, String pass, DataInputStream dis, DataOutputStream dos) {
        
        try {
            dos.writeUTF("registrate");
            dos.flush();
            
            //System.out.println(str);
            dos.writeUTF(Login);
            dos.flush();
            //System.out.println(pass);
            dos.writeUTF(pass);
            dos.flush();
            
            return dis.readBoolean();
        } catch (IOException ex) {
            Logger.getLogger(FirstWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
                       
    }

    @Override
    public boolean Authorization(String Login, String pass, DataInputStream dis, DataOutputStream dos) {
         
        try {
            dos.writeUTF("check");
        
                dos.flush();
                
                System.out.println(Login);
                dos.writeUTF(Login);
                dos.flush();
                
                System.out.println(pass);
                dos.writeUTF(pass);
                dos.flush();
        
                return dis.readBoolean();
                
                } catch (IOException ex) {
            Logger.getLogger(FirstWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
