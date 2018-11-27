/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.util.Vector;

/**
 *
 * @author Umlore
 */
public class TreeChanges extends Thread implements TreeChangesInterface {
    
    private boolean IsStarted;
    private int speed;  // 2000 - x1, 1000 - x2, 400 - x5, 200 - x10;
    private int HMSteps;
    public TreeChanges() {
        speed = 2000;
        IsStarted = false;
        HMSteps = 0;
    }
    
    @Override
    public void ChangeGrowthSpeed(int newSpeed) {
        speed = newSpeed;
        System.out.println("I'm change speed!");
    }
        
    @Override
    public void GrowthStep() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SaveChange() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DestroyBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int GetChange(){
        return HMSteps;
    }

    @Override
    public void StopGrowth(){       // Остановить рост
        IsStarted = false;
    }
    
    @Override
    public void run(){
        System.out.println("Growth is started!");
        IsStarted = true;
        while (IsStarted){
            HMSteps++;
        }
    }
    
}
