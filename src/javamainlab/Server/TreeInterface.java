/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

enum pixel {leaves, bark , trunk , air}; // листья, кора, ствол, воздух

/**
 *
 * @author Umlore
 */
public interface TreeInterface {
     
    void SaveTree();
    
    void SetTree(Object obj /* скорее всего это будет массив изменений дерева */);
    
    Object GetTree();
}
