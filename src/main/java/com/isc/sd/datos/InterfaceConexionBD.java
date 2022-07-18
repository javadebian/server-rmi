/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.datos;

import com.isc.sd.cliente.UsuarioBean;

/**
 *
 * @author metalklesk
 */
public interface InterfaceConexionBD {
    
    //retorna true en caso de conectar, false en caso contrario
    public boolean conectarBD();
    //retorna la deuda del usuario
    public String obtenerDeuda(String rut);
    //actualiza la deuda al pagar
    public boolean actualizarDeuda(String rut, int monto);
    //retorna true en el caso de que el usuario existe en la BD, false en caso contrario
    public boolean existeUsuario(String rut);
    //retorna un UsuarioBean para manejar sus datos en la pagina
    public UsuarioBean obtenerUsuario(String rut);
}
