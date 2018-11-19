/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.util.ArrayList;
import static javamainlab.Server.pixel.air;
import static javamainlab.Server.pixel.bark;
import static javamainlab.Server.pixel.leaves;
import static javamainlab.Server.pixel.trunk;

/**
 *
 * @author Umlore
 */
public class Tree implements TreeInterface{
    pixel[][] colorPixel;
    
    public Tree(){
        colorPixel = new pixel[240][240];
        for (int i = 0; i < 240 ; i++)
            for (int j = 0; j < 240 ; j++)
                colorPixel[i][j] = air;
        /* creating default tree */
    }

    @Override
    public void SaveTree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetTree(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
