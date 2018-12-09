/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

import javamainlab.Server.*;

/**
 *
 * @author Umlore
 */

enum GrowthDirection { left, right, up};



public interface BranchInterface {
    
    public static double PI = 3.1415926535;
    
    public Branch GenerateChildBranch();
    
    public void DeleteThisBranch();
        
    public BranchInterface GetParentBranch();
    
    public BranchInterface GetClildFirstBranch();
    
    public BranchInterface GetClildSecondBranch();
    
    public BranchInterface ReturnThisBranch();
    
    // листья потом сделаем
}