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
public class Observer extends Thread{
    
    private ImageHandler _IH;
    private ClientGUI CGU;
    private int _speed;
    
    public Observer(ImageHandler IH, ClientGUI CGUI){
        _IH = IH;
        CGU = CGUI;
        _speed = 1000;
    }
    
    public void ChangeSpeed(int speed){
        _speed = speed;
    }
    
    @Override
    public void run() {
        while (true) {
            try {
                sleep(_speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(Observer.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (_IH.GetChanges()) {
                CGU.ReDraw();
            }
        }
    }
}
