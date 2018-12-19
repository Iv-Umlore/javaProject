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
import java.util.Hashtable;

/**
 *
 * @author Umlore
 */
public class UserIdentification implements UserIdentificationInterface {
    
    private Hashtable users;
    
    private Hashtable OpenHT() throws FileNotFoundException, IOException{
        String Login, pass;
        Hashtable<String,String> HT = new Hashtable<String,String>();
        FileReader FR = new FileReader("src\\javamainlab\\Users\\Users.txt");
        int i = 0;
        while ((i = FR.read())!= -1){
            Login = "";
            pass = "";           
            
            while((char)i !=' '){
                Login = Login + (char)i;
                i = FR.read();                 
            }
            while (((char)(i = FR.read()) != '\r') && (i != -1))  {
                pass = pass + (char)i;                
            } 
            i = FR.read();
            HT.put(Login, pass);
        }
        FR.close();
        
        for (Object key : HT.keySet()) {           
           System.out.println(key + " " +HT.get(key)); 
        }
        
        return HT;
    }
    
    private void SaveHT() throws IOException{
        int i=1;
        FileWriter FW = new FileWriter("src\\javamainlab\\Users\\Users.txt");
        String Login = "";
        for (Object key : users.keySet()) {
           FW.write((String) key + " " + users.get(key) + '\r');
           if (i < users.size()){
               FW.write('\n');
               i++;
           }
        }        
        FW.write(-1);
        FW.close();
    }
    
    public UserIdentification() throws IOException{
        users = OpenHT();
    }    
    
    @Override
    public boolean Registration( String new_login, String new_pass) throws IOException {
        users.put(new_login, new_pass);
        SaveHT();
        return true;
    } 
    
    public boolean CheckLogPas( String Login, String pass){
        return (users.get(Login).equals(pass));
    }
    
    
}
