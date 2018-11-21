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
public interface TreeManagementInterface {
    
    void Refresh(/*здесь могла быть ваше изображение*/); // вынести отдельно
    // + наблюдатель
    
    void SetSpeed(int speed);
    
    void DeleteBranch(Object obj);
    
    // void PaintTree
    // get current tree
}
