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
       
    public BranchInterface GetParentBranch();
    
    public BranchInterface GetClildFirstBranch();
    
    public BranchInterface GetClildSecondBranch();
    
    public BranchInterface FromString(String str, BranchInterface Parent);
    
    public void SetBranch(String str);
    
    public String ReturnThisBranch();
    
    // листья потом сделаем
}
