/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import static javamainlab.Server.GrowthDirection.up;

/**
 *
 * @author Umlore
 */
public class Tree implements TreeInterface{
    
    private BranchInterface MainBranch;
    private BranchInterface CurrentBranch;
    
    
    public Tree(){
        MainBranch = new Branch(up,120,240,null);
        CurrentBranch = MainBranch;
    }

    @Override
    public void SaveTree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SetTree(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BranchInterface GetTree() {
        return MainBranch;      
    }
    
    
}
