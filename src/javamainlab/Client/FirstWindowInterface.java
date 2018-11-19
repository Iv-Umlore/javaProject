/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javamainlab.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**
 *
 * @author Umlore
 */
public interface FirstWindowInterface {
    boolean Registration(String Login, String pass, DataInputStream dis, DataOutputStream dos);
    boolean Authorization(String Login, String pass, DataInputStream dis, DataOutputStream dos);
}
