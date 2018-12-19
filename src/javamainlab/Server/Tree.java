/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javamainlab.Server.GrowthDirection.up;

/**
 *
 * @author Umlore
 */
public class Tree implements TreeInterface{
    
    private BranchInterface MainBranch;
    //private BranchInterface CurrentBranch;
    
    private String FileWay;
    private FileReader FR;
    private FileWriter FW;
    
    
    private String thisTree;
    
    public Tree(String UN, boolean Bol) throws FileNotFoundException, IOException{
        // Bol = true - Создание нового дерева, Bol = false - загрузка
        
        FileWay = "src\\javamainlab\\Users\\" + UN + ".txt";
        
        if (Bol) {
            MainBranch = new Branch(up,120,240,null);
            //CurrentBranch = MainBranch;
            SaveTree();
        }
        else {
            MainBranch = new Branch(up,120,240,null);
            SetTree();
        }       
        
        
        
    }

    @Override
    public void SaveTree() { 
        try {
            FW = new FileWriter(FileWay);
            FW.write(this.ToString());
            FW.close();
        } catch (IOException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SetTree() {
        
        try {
            
            int i;
            String str = "";
            
            FR = new FileReader(FileWay);
            
            while ((i = FR.read())!= -1) {
                str += (char)i;
            }

            System.out.println(str);
            
            i = 0;
            while (str.charAt(i) != ' ') {
                i++;
            }
            
            str = str.substring(i);
            
            MainBranch.FromString(str,null);
            
            FR.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public BranchInterface GetTree() {
        return MainBranch;      
    }

    @Override
    public String ToString() {
        thisTree = "";
        
        thisTree = String.valueOf(MainBranch.ReturnNumberAll());
        
        thisTree += MainBranch.ToString();
                
        return thisTree;
    }
    
    
}
