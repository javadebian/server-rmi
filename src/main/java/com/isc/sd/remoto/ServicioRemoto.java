/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.remoto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.isc.sd.cliente.UsuarioBean;
import com.isc.sd.logica.LogicaNegocio;

/**
 *
 * @author metalklesk
 */
public class ServicioRemoto extends UnicastRemoteObject implements InterfaceRemota{

    private LogicaNegocio ln;
    
    public ServicioRemoto() throws RemoteException{
        ln = new LogicaNegocio();
    }
    
    public String obtenerDeuda(String rut) throws RemoteException {
        String respuesta = ln.obtenerDeuda(rut);
        return respuesta;
    }

    public String pagarDeuda(String rut, String monto) throws RemoteException {
        String respuesta = ln.pagarDeuda(rut, monto);
        return respuesta;
    }

    public UsuarioBean obtenerUsuario(String rut) throws RemoteException {
        UsuarioBean usuario = ln.obtenerUsuario(rut);
        return usuario;
    }

    
}
