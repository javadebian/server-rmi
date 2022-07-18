/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author metalklesk
 */
public class Teclado implements Runnable{

    private BufferedReader entrada;
    
    public Teclado(){
        entrada = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public void run() {
        System.out.println("Para detener el servidor ingrese STOP en la linea de comandos.");
        
        while(true){
            try {
                if (entrada.readLine().equalsIgnoreCase("stop")) {
                    System.out.println("Servidor detenido.");
                    System.exit(0);
                }
            } catch (IOException ex) {
                Logger.getLogger(Teclado.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Servidor detenido.");
                System.exit(0);
            }
        }
    }
}
