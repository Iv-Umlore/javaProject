/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */
public class ImageHandler extends Thread{
    
    private ImageInterface image;
    private ClientSpeakerInterface _CSI;
    
    public ImageHandler(ClientSpeakerInterface CSI){
        _CSI = CSI;
        image = new Image();
    }
    
    @Override
    public void run() {
        while (true) {
            image.SetTree(_CSI.GetImage());
            System.out.println(image.GetTree());
            try {    
                sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(ImageHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
                }
    }
}
