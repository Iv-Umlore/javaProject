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
public interface  TreeChangesInterface {
    
    void ChangeGrowthSpeed(int newSpeed);
    
    void GrowthStep(); // 1 такт роста
    
    void SaveChange(); // сохраняем изменения, как в git
    
    void DestroyBranch(); // Уничтожить ветку
    
    int GetChange(); // выдать изменения с момента последнего обращения
    
    void StopGrowth();
    
    void run();
}
