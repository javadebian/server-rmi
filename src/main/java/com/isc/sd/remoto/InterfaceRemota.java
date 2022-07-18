/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.remoto;

import java.rmi.Remote;

import com.isc.sd.cliente.UsuarioBean;

/**
 *
 * @author metalklesk
 */
public interface InterfaceRemota extends Remote{

    public String obtenerDeuda(String rut) throws java.rmi.RemoteException;
    
    public String pagarDeuda(String rut, String monto) throws java.rmi.RemoteException;
    
    public UsuarioBean obtenerUsuario(String rut) throws java.rmi.RemoteException;
}
