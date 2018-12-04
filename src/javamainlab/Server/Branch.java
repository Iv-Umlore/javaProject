/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;
import java.util.Random;
/**
 *
 * @author Umlore
 */

public class Branch implements BranchInterface{
        
    private GrowthDirection Direct;
    private int StartX, StartY;
    private int length, width;
    private double parametrT;
    private int numberAllBranch;
    private int numberHerBranches;

    private Random rand;
        
    public Branch(GrowthDirection _thisBranch, int X, int Y) {
        
        rand = new Random();
                
        StartX = X;
        StartY = Y;
        Direct = _thisBranch;
        length = rand.nextInt(5) + 4;
        width = 1;
        numberAllBranch = 0;
        numberHerBranches = 0;
        if (parametrT < 0) {
            switch (Direct) {
                case up : {
                    parametrT = rand.nextDouble() % (PI/3) + (PI/3); 
                    // угол 60 - 120 градусов
                    break;
                }
                case right : {
                    parametrT = rand.nextDouble() % (PI/3);
                    // угол 0 - 60 градусов
                    break;
                }
                case left : {
                    parametrT = rand.nextDouble() % (PI/3) + 2*(PI/3);
                    // угол 120 - 180 градусов
                    break;
                }
            }
        }
        
    }
        
    
    @Override
    public void GenerateChildBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteThisBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BranchInterface GetParrentBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BranchInterface GetClildFirstBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BranchInterface GetClildSecondBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BranchInterface ReturnThisBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
