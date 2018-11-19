/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

/**
 *
 * @author Umlore
 */
public interface TreeChangesInterface {
    
    void GrowthStep(); // 1 такт роста
    
    void SaveChange(); // сохраняем изменения, как в git
    
    void DestroyBranch(); // Уничтожить ветку
}
