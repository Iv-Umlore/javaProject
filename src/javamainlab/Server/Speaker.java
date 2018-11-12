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

/**
 *
 * @author Umlore
 */
public class Speaker extends Thread{
    
    Socket sock;
    DataInputStream dis;        // can be changed to ObjectStream
    DataOutputStream dos;       // can be changed to ObjectStream
    
    public Speaker (Socket s) throws IOException{
        sock = s;
        dis = new DataInputStream(sock.getInputStream());
        dos = new DataOutputStream(sock.getOutputStream());
    }
    
    @Override
    public void run(){
        // The algorithm of interaction will be here
    }
    
    
}
