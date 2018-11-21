/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Server;

import java.io.IOException;

/**
 *
 * @author Umlore
 */
public interface UserIdentificationInterface {
    
    boolean Registration( String new_login, String new_pass) throws IOException;
    
    boolean CheckLogPas( String Login, String pass);
}
