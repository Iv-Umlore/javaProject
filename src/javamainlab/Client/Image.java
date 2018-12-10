/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

/**
 *
 * @author Umlore
 */
public class Image implements ImageInterface {    
    
    int[][] arr;
    
    Branch mainBranch;
    
    Image() {}
    
    public int[][] ReturnArray() {
        return arr;
    }
    
    @Override
    public void Refresh() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void PaintTree(Object tree) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] GetImage() {
        return arr;
    }

    @Override
    public String GetTree() {
        return mainBranch.ReturnThisBranch();
    }

    @Override
    public void SetTree(String str) {
        mainBranch.SetBranch(str);
    }
    
    
}
