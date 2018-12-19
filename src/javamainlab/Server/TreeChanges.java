/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Umlore
 */
public class TreeChanges extends Thread implements TreeChangesInterface {
    
    private boolean IsStarted;
    private int speed;  // 2000 - x1, 1000 - x2, 400 - x5, 200 - x10;
    private int count;   
    
    private TreeInterface tree;  
    
    public TreeChanges(String UN, boolean Bol) {
        
        speed = 2000;
        IsStarted = false;
        count = 0;
        
        try {                
            tree = new Tree(UN, Bol);
        } catch (IOException ex) {
            Logger.getLogger(TreeChanges.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void ChangeGrowthSpeed(int newSpeed) {
        speed = 2000/newSpeed;
        System.out.println("I'm change speed!");
    }
        
    @Override
    public void GrowthStep() {
        tree.GetTree().Growth();
        System.out.println("step");
    }

    @Override
    public void SaveTree() {
        tree.SaveTree();
    }

    @Override
    public void DestroyBranch() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String GetChange(){
        return tree.ToString();
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
            GrowthStep();
            count++;
            if (count >= 5) {
                tree.SaveTree();
                count = 0;
            }
            //System.out.println(tree.ToString());
            try {
                sleep(speed);
            } catch (InterruptedException ex) {
                Logger.getLogger(TreeChanges.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
