/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;
import java.util.Random;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.round;
import static javamainlab.Client.GrowthDirection.up;
import static javamainlab.Client.GrowthDirection.right;
import static javamainlab.Client.GrowthDirection.left;
/**
 *
 * @author Umlore
 */

public class Branch implements BranchInterface{
        
    private GrowthDirection Direct;
    private int StartX, StartY;
    private final int FinalX, FinalY;
    private int length, width;
    private double parametrT;
    private int numberAllBranch;
    private int numberHerBranches;
    
    private BranchInterface ParentBranch;    
    private BranchInterface ClildFirstBranch;
    private BranchInterface ClildSecondBranch;

    private boolean IsGrowth;
    
    private Random rand;
        
    public Branch(GrowthDirection _thisBranch, int X, int Y, BranchInterface Parent) {
        // ( Параметры )
        IsGrowth = false;
        
        ParentBranch = Parent;
        ClildFirstBranch = null;
        ClildSecondBranch = null;
        
        rand = new Random();
                
        StartX = X;
        StartY = Y;
        Direct = _thisBranch;
        length = rand.nextInt(5) + 4;
        width = 1;
        numberAllBranch = 0;
        numberHerBranches = 0;
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
        
        FinalX = StartX + (int)(round(cos(parametrT)));
        FinalY = StartY + (int)(round(sin(parametrT)));
    }
        
    
    @Override
    public Branch GenerateChildBranch(/*1ая или вторая ветка, и все параметры для brance*/) {
        return this;
    }

    @Override
    public void DeleteThisBranch() {
        if (ClildSecondBranch != null) ClildSecondBranch.DeleteThisBranch();
        ClildSecondBranch = null;
        if (ClildFirstBranch != null) ClildFirstBranch.DeleteThisBranch();
        ClildFirstBranch = null;    
    }

    @Override
    public BranchInterface GetParentBranch() {
        return ParentBranch;
    }

    @Override
    public BranchInterface GetClildFirstBranch() {
        return ClildFirstBranch;
    }

    @Override
    public BranchInterface GetClildSecondBranch() {
        return ClildSecondBranch;
    }

    @Override
    public BranchInterface ReturnThisBranch() {
        return this;
    }
      
}
