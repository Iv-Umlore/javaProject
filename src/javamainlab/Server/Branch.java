/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;
import java.util.Random;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.round;
import static javamainlab.Server.GrowthDirection.up;
import static javamainlab.Server.GrowthDirection.right;
import static javamainlab.Server.GrowthDirection.left;
/**
 *
 * @author Umlore
 */

public class Branch implements BranchInterface{
        
    private GrowthDirection Direct;
    private int StartX, StartY;
    private int FinalX;
    private int FinalY;
    private int length, width;
    private double parametrT;
    public int numberAllBranch;
    private int numberHerBranches;
    
    private String thisBranch;
    
    private BranchInterface ParentBranch;    
    private BranchInterface ClildFirstBranch;
    private BranchInterface ClildSecondBranch;

    private boolean IsGrowth;
    
    private Random rand;
        
    public Branch(GrowthDirection _thisBranch, int X, int Y, BranchInterface Parent) {
        
        IsGrowth = false;
        
        ParentBranch = Parent;
        ClildFirstBranch = null;
        ClildSecondBranch = null;
        
        rand = new Random();
                
        StartX = X;
        StartY = Y;
        Direct = _thisBranch;
        length = rand.nextInt(5) + 4;
        width = 1;
        numberAllBranch = 1;
        numberHerBranches = 0;
            switch (Direct) {
                case up : {
                    parametrT = rand.nextDouble() % (PI/3) + (PI/3); 
                    // угол 60 - 120 градусов
                    break;
                }
                case right : {
                    parametrT = rand.nextDouble() % (PI/3);
                    // угол 0 - 60 градусов
                    break;
                }
                case left : {
                    parametrT = rand.nextDouble() % (PI/3) + 2*(PI/3);
                    // угол 120 - 180 градусов
                    break;
                }
            }
        
        FinalX = StartX - (int)round(length * cos(parametrT));
        FinalY = StartY - (int)round(length * sin(parametrT));
    }
        
    
    @Override
    public void GenerateChildBranch() {
        if (numberHerBranches < 2){
            
            if (numberHerBranches == 1) { 
                if (ClildFirstBranch == null) ClildFirstBranch = new Branch(GenerateDirection(Direct), FinalX, FinalY, this);
                else ClildSecondBranch  = new Branch(GenerateDirection(Direct), FinalX, FinalY, this);
                PlusPlusBranch();   
                numberHerBranches++;             
            }
            
            if (numberHerBranches == 0) { 
                ClildFirstBranch = new Branch(GenerateDirection(Direct), FinalX, FinalY, this);
                PlusPlusBranch();                
                numberHerBranches++;
            }            
        }
    }

    @Override
    public void DeleteThisBranch() {
        if (ClildSecondBranch != null) ClildSecondBranch.DeleteThisBranch();
        ClildSecondBranch = null;
        if (ClildFirstBranch != null) ClildFirstBranch.DeleteThisBranch();
        ClildFirstBranch = null;    
    }

    @Override
    public BranchInterface GetParentBranch() {
        return ParentBranch;
    }

    @Override
    public BranchInterface GetClildFirstBranch() {
        return ClildFirstBranch;
    }

    @Override
    public BranchInterface GetClildSecondBranch() {
        return ClildSecondBranch;
    }

    @Override
    public BranchInterface ReturnThisBranch() {
        return this;
    }

    @Override
    public void PlusPlusBranch() {
        numberAllBranch++;
        width = round(numberAllBranch / 2);
        if ((this.GetParentBranch()) != null) GetParentBranch().PlusPlusBranch();
    }
    
    private GrowthDirection GenerateDirection(GrowthDirection that){
        
        rand = new Random();
        
        int numb = rand.nextInt(100);
        switch (that) {
            case up : {
                    if ((numb > 15) && (numb < 85)) return up;
                    if (numb <=15) return left;
                    if (numb >=85) return right;
                    break;
                }
                case right : {
                    if (numb > 9) return right;
                    if (numb <=9) return up;
                    break;
                }
                case left : {
                    if (numb < 89) return left;
                    if (numb >=89) return up;
                    break;
                }
        }
        return up;
    }

    @Override
    public void Growth() {
        
        rand = new Random();              
                
        if (ClildFirstBranch!= null) {
            ClildFirstBranch.Growth();
        }
        if (ClildSecondBranch != null) {
            ClildSecondBranch.Growth();
        } 
          
        if (numberHerBranches < 2) {
            
        }
            int numb = rand.nextInt(100);
            
            if (numb > 87) {
                
            numb = rand.nextInt(100);
            if (Direct == up) {
                if (numb > 55) GenerateChildBranch();
                IsGrowth = true;
            }
            if ((Direct == left) || (Direct == right))
                if (numb < 12) {
                    GenerateChildBranch();
                    IsGrowth = true;
                }
        }
    }

    @Override
    public boolean IsGrowth() {
        boolean result = IsGrowth;
        IsGrowth = false;   // При данном запросе обнуляем статус изменений
        return result;
    }

    @Override
    public String ToString() {
        
        thisBranch = "";
        
        thisBranch = " " + String.valueOf(Direct) + " " + String.valueOf(StartX) + " " +
                String.valueOf(StartY) + " " + String.valueOf(FinalX) + " " +
                String.valueOf(FinalY) + " " + String.valueOf(width) + " " +
                String.valueOf(numberHerBranches) + '\n';
        
        if (ClildFirstBranch != null) {
            thisBranch = thisBranch + ClildFirstBranch.ToString();
        }
        if (ClildSecondBranch != null) {
            thisBranch = thisBranch + ClildSecondBranch.ToString();
        }
        
        return thisBranch;
    }
    
    @Override
    public int ReturnNumberAll() {
        return numberAllBranch;
    }

    @Override
    public Branch FromString(String str, BranchInterface point) {
        
        numberAllBranch = 1;
        
        int i = 0;
        String thisBranch = "";
        
        ClildFirstBranch = null;
        ClildSecondBranch = null;
        
        ParentBranch = point;
        
        while ((str.charAt(i)) != '\n'){
            thisBranch += str.charAt(i);
            i++;            
        }
        
        thisBranch += str.charAt(i);
        i++;   
        
        //numberAllBranch = 0;
        SetBranch(thisBranch);
        //System.out.println(thisBranch);
        if (i < str.length())
            str = str.substring(i + 1);
        
        if (numberHerBranches == 1) {
            ClildFirstBranch = ClildFirstBranch.FromString(str,this);
        }
        
        if (numberHerBranches == 2) {
            System.out.println(str);
            ClildFirstBranch = FromString(str,this);
            System.out.println(str);
            ClildSecondBranch = FromString(str,this);
        }
        
        PlusPlusBranch();
        
        return this;
        
    }

    @Override
    public void SetBranch(String str) {
        
        String timeString;
        int i = 0, wordnumb = 0;
        int maxChars = str.length();
                
        while (i < maxChars - 1) {
            
            if (str.charAt(i) == ' ') i++;
            
            timeString = "";
            while ((str.charAt(i) != ' ') && (str.charAt(i) != '\n')) {                
                timeString += str.charAt(i);
                i++;
            }            
           
            
            switch (wordnumb) {
                case 0: {
                    if (timeString.equalsIgnoreCase("up")) Direct = up;
                    if (timeString.equalsIgnoreCase("left")) Direct = left;
                    if (timeString.equalsIgnoreCase("right")) Direct = right;
                    break;
                }
                case 1: {                    
                    StartX = Integer.parseInt(timeString);
                    break;
                }
                case 2: {
                    StartY = Integer.parseInt(timeString);
                    break;
                }
                case 3: {
                    FinalX = Integer.parseInt(timeString);
                    break;
                }
                case 4: {
                    FinalY = Integer.parseInt(timeString);
                    break;
                }
                case 5: {
                    width = Integer.parseInt(timeString);
                    break;
                }
                case 6: {
                    numberHerBranches = Integer.parseInt(timeString);
                    break;
                }               
            }
           wordnumb++;
        }
    }
    
}