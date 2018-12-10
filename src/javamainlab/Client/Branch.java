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
    private int FinalX, FinalY;
    private int width;    
    private int numberHerBranches;    
    private BranchInterface ParentBranch;    
    private BranchInterface ClildFirstBranch;
    private BranchInterface ClildSecondBranch;

    private String thisBranch;
    
        
    public Branch(String str/*,GrowthDirection _thisBranch, int X, int Y, BranchInterface Parent*/) {
        thisBranch = str;
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
    public String ReturnThisBranch() {
        return thisBranch;
    }

    @Override
    public BranchInterface FromString(String str, BranchInterface Parent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetBranch(String str) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
