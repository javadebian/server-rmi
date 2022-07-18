package com.isc.sd;

import com.isc.sd.run.Servicio;
import com.isc.sd.run.Teclado;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Thread hilo = new Thread(new Teclado());
        hilo.start();

        Servicio servicio = new Servicio();
        if(servicio.iniciarServicio()){
            System.out.println("Servidor iniciado.");
        }
    }
}
