/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

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
public class ClientSpeaker implements ClientSpeakerInterface {

    private int speed = 1;
    private Socket server; 
    private DataInputStream dis;
    private DataOutputStream dos;
    
    ClientSpeaker(Socket serv) throws IOException{
        server = serv;
        dis = new DataInputStream(server.getInputStream());
        dos = new DataOutputStream(server.getOutputStream());
        System.out.println("ClientSpeaker is done! ");
    }
    
    @Override
    public void SpeedChange(int newSpeed) {
        
        if (newSpeed != speed) {    
            try {
                dos.writeUTF("speed");
                dos.flush();
                dos.write(newSpeed);
                dos.flush();
                speed = newSpeed;
            } catch (IOException ex) {
                Logger.getLogger(ClientSpeaker.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        }

    @Override
    public void DestroyBranch() {
        try {
            dos.writeUTF("destroy");
            dos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ClientSpeaker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
