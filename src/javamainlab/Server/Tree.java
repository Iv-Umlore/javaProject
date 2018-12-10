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
    private BranchInterface CurrentBranch;
    
    private String FileWay;
    private FileReader FR;
    private FileWriter FW;
    
    
    private String thisTree;
    
    public Tree(String UN, boolean Bol) throws FileNotFoundException, IOException{
        // Bol = true - Создание нового дерева, Bol = false - загрузка
        
        FileWay = "src\\javamainlab\\Users\\" + UN + ".bin";
        FW = new FileWriter(FileWay);
        if (Bol) {
            MainBranch = new Branch(up,120,240,null);
            CurrentBranch = MainBranch;
            
        }
        else {
            FR = new FileReader(FileWay);
            SetTree();
        }       
        
    }

    @Override
    public void SaveTree() {        
        try {
            FW.write(this.ToString());
        } catch (IOException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SetTree() {
        
        int i;
        String str = "";
        
        try {        
        while ((i = FR.read())!= -1) {
                str = str + (char)i;
            }
        } catch (IOException ex) {
            Logger.getLogger(Tree.class.getName()).log(Level.SEVERE, null, ex);
        }
        i = 0;
        while (str.charAt(i) != ' ') {
            i++;
        }
        
        str = str.substring(i);
        
        MainBranch.FromString(str,null);
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
