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
public interface ImageInterface {
    // + наблюдатель
     public void Refresh(/*здесь могла быть ваше изображение*/);
    
     public void PaintTree(Object tree);
     
     public int[][] GetImage();
     
     
}