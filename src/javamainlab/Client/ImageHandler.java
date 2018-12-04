/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

/**
 *
 * @author Umlore
 */
public class ImageHandler extends Thread{
    
    ImageInterface image;
    
    public ImageHandler(){
        image = new Image();
    }
    
    @Override
    public void run() {
        
    }
}
