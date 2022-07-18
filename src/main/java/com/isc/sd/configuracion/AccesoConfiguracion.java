/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.configuracion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author metalklesk
 */
public class AccesoConfiguracion {
    
    private static AccesoConfiguracion config = new AccesoConfiguracion();
    private BufferedReader br;
    private String servidor;
    private String servicioRMI;
    private String puertoBD;
    private String nombreBD;
    private String tipoConexionBD;
    private String driverBD;
    private String usuarioBD;
    private String passwdBD;
    
    private AccesoConfiguracion() {
        getDatos();
    }
    
    public synchronized static AccesoConfiguracion getInstance(){
        return config;
    }
    
    private void getDatos(){
        try {
            br = new BufferedReader(new FileReader("config/config.conf"));
            servidor = br.readLine().split("=")[1];
            servicioRMI = br.readLine().split("=")[1];
            puertoBD = br.readLine().split("=")[1];
            nombreBD = br.readLine().split("=")[1];
            tipoConexionBD = br.readLine().split("=")[1];
            driverBD = br.readLine().split("=")[1];
            usuarioBD = br.readLine().split("=")[1];
            passwdBD = br.readLine().split("=")[1];

        } catch (IOException ex) {
            System.out.println("No se pudo leer el archivo de configuracion.");
            Logger.getLogger(AccesoConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(AccesoConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public synchronized String getHost(){
        return servidor;
    }
    
    public synchronized String getServicioRMI(){
        return servicioRMI;
    }
    
    public synchronized String getPuertoBaseDatos(){
        return puertoBD;
    }
    
    public synchronized String getNombreBaseDatos(){
        return nombreBD;
    }
    
    public synchronized String getTipoConexion(){
        return tipoConexionBD;
    }
    
    public synchronized String getDriverBD(){
        return driverBD;
    }
    
    public synchronized String getUsuarioBD(){
        return usuarioBD;
    }
    
    public synchronized String getPassWdBD(){
        return passwdBD;
    }
    
    @Override
    public void finalize(){
        try {
            if (br != null) {
                br.close();
            }
        } catch (IOException ex) {
            Logger.getLogger(AccesoConfiguracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
