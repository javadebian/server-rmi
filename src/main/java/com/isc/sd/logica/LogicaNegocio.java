/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.logica;

import com.isc.sd.cliente.UsuarioBean;
import com.isc.sd.datos.ConexionBDSimple;

/**
 *
 * @author metalklesk
 */
public class LogicaNegocio {

    private ConexionBDSimple con;
    private boolean conectado = false;
    
    public LogicaNegocio() {
        if (!(conectado = conectarse())){
            System.exit(1);
        }
    }

    public boolean conectarse(){
        con = new ConexionBDSimple();
        if(!con.conectarBD())
            return false;
        else
            return true;
    }
    
    public UsuarioBean obtenerUsuario(String rut){
        if(conectado){
            if(!con.existeUsuario(rut)){
                return null;
            }
            else{
                UsuarioBean usuario = con.obtenerUsuario(rut);
                return usuario;
            }
        }else
            return null;
    }
    
    public String obtenerDeuda(String rut){
        if(conectado){
            if(!con.existeUsuario(rut)){
                return "No tiene deuda que pagar";
            }
            else{
                String deuda = con.obtenerDeuda(rut);
                return deuda;
            }
        }else
            return "No hay conexion con la base de datos.";
    }
    
    public String pagarDeuda(String rut, String monto){
        if(conectado){
            if(!con.existeUsuario(rut)){
                return "No tiene deuda que pagar";
            }

            int deuda = Integer.parseInt(obtenerDeuda(rut));
            int m = Integer.parseInt(monto);
            
            if(deuda == 0){
                return "No tiene deuda que pagar";
            }
            
            if(m <= 0){
                return "No puede pagar cero pesos.";
            }
            
            if(m > deuda){
                return "No puede pagar mas de lo que debe.";
            }

            int total = deuda - m;

            if(!con.actualizarDeuda(rut, total)){
                return "Ha ocurrido un error, por favor intente mas tarde.";
            }else{
                return "El monto ha sido pagado.";
            }
        }else
            return "No hay conexion con la base de datos.";
    }
}
