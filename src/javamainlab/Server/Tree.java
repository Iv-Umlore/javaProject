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

enum pixel {leaves, bark , trunk , air}; // листья, кора, ствол, воздух

/**
 *
 * @author Umlore
 */
public class Tree {
    pixel[][] colorPixel;
    
    public Tree(){
        colorPixel = new pixel[240][240];
        for (int i = 0; i < 240 ; i++)
            for (int j = 0; j < 240 ; j++)
                colorPixel[i][j] = air;
        
        // it's hardcode now
        
        int i = 0;              
        int j = 239;
        
        colorPixel[117][j] = bark;
        for (i=118;i<120;i++)
            colorPixel[i][j] = trunk;
        colorPixel[i][j] = bark;
        
        j=238;
        colorPixel[117][j] = bark;
        for (i=118;i<119;i++)
            colorPixel[i][j] = trunk;
        colorPixel[i++][j] = bark;
        colorPixel[i][j] = bark;
        
        j = 237;
        colorPixel[118][j] = bark;
        colorPixel[119][j] = trunk;
        colorPixel[120][j] = bark;
        
        j = 236;
        colorPixel[118][j] = bark;
        colorPixel[119][j] = trunk;
        colorPixel[120][j] = bark;
        
        j = 235;
        colorPixel[118][j] = bark;
        colorPixel[119][j] = trunk;
        colorPixel[120][j] = bark;
        
        j = 234;
        colorPixel[118][j] = bark;
        colorPixel[119][j] = bark;
        
        j = 233;
        colorPixel[119][j] = bark;
        
        j = 232;
        colorPixel[119][j] = bark;
        
        j = 231;
        colorPixel[120][j] = leaves;
        colorPixel[121][j] = leaves;
        
        j = 230;
        colorPixel[121][j] = leaves;
        colorPixel[122][j] = leaves;
    }
}
