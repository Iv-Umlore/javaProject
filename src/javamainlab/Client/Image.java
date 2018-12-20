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
    
    String Tree;
    
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
    public void SetTree(String str) {
        
        Tree = "";
        int ForFor = 0;
        int i = 0;
        int j = 0;
        String LocalTree = "";
        
        while(str.charAt(i) != ' '){
            LocalTree += str.charAt(i);
            i++;
        }
        
        ForFor = Integer.parseInt(LocalTree);
        
        int wordnumb;
        for (j = 0; j < ForFor; j++) { 
            wordnumb = 0;
        while (str.charAt(i) != '\n') {
            
            if (str.charAt(i) == ' ') i++;
            
            LocalTree = "";
            while ((str.charAt(i) != ' ') && (str.charAt(i) != '\n')) {                
                LocalTree += str.charAt(i);
                i++;
            }            
           
            
            switch (wordnumb) {
                case 0: {
                    break;
                }
                case 1: {                    
                    Tree += "( " + LocalTree + ", ";
                    break;
                }
                case 2: {
                    Tree += LocalTree + " )";
                    break;
                }
                case 3: {
                    Tree += " ( " + LocalTree + ", ";
                    break;
                }
                case 4: {
                    Tree += LocalTree + " ) ";
                    break;
                }
                case 5: {
                    Tree += " width : " + LocalTree;
                    break;
                }
                case 6: {
                    Tree += '\n';
                    break;
                }  
                default: break;
            }
           wordnumb++;
        }        
        i++;
        } 
    }

    @Override
    public String GetImageTree() {
        return Tree;
    }
    
    @Override
    public void Draw() {
        System.out.println(Tree);
    }
    
}
