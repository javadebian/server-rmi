/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.run;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.isc.sd.configuracion.AccesoConfiguracion;
import com.isc.sd.remoto.ServicioRemoto;

/**
 *
 * @author metalklesk
 */
public class Servicio {

    private ServicioRemoto servicio;

    public Servicio() {
        try {
            servicio = new ServicioRemoto();
        } catch (RemoteException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }
    
    public boolean iniciarServicio(){
        try {
            Naming.rebind((AccesoConfiguracion.getInstance()).getServicioRMI(), servicio);
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean pararServicio(){
         try {
            Naming.unbind((AccesoConfiguracion.getInstance()).getServicioRMI());
            return true;
        } catch (RemoteException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (NotBoundException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (MalformedURLException ex) {
            Logger.getLogger(Servicio.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @Override
    public void finalize(){
        pararServicio();
    }
}
