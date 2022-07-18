/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.isc.sd.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.isc.sd.cliente.UsuarioBean;
import com.isc.sd.configuracion.AccesoConfiguracion;

/**
 *
 * @author metalklesk
 */
public class ConexionBDSimple implements InterfaceConexionBD{

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private AccesoConfiguracion datos = AccesoConfiguracion.getInstance();
    
    public String obtenerDeuda(String rut) {
        try {
            ps = con.prepareStatement("select deuda from usuario where rut = " + "'" + rut + "'");
            rs = ps.executeQuery();
            if(rs.next()){
                String deuda = String.valueOf(rs.getInt("deuda"));
                return deuda;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean actualizarDeuda(String rut, int monto) {
        try {
            ps = con.prepareStatement("update usuario set deuda = " + monto +
                    " where rut = " + "'" + rut + "'");
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean existeUsuario(String rut) {
        try {
            ps = con.prepareStatement("select * from usuario where rut = " + "'" + rut + "'");
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public UsuarioBean obtenerUsuario(String rut) {
        UsuarioBean usuario = new UsuarioBean();
        try {
            ps = con.prepareStatement("select * from usuario where rut = " + "'" + rut + "'");
            rs = ps.executeQuery();
            if(rs.next()){
                usuario.setRut(rs.getString("rut"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
                usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuario;
    }

    public boolean conectarBD() {
        
        try {
            Class.forName(datos.getDriverBD()).newInstance();
        } catch (Exception ex){
            Logger.getLogger(ConexionBDSimple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo cargar el driver.");
            return false;
        }
        
        try {
            con = DriverManager.getConnection(datos.getTipoConexion() + "://" + 
                    datos.getHost() + ":" + datos.getPuertoBaseDatos() + "/" +
                    datos.getNombreBaseDatos(), datos.getUsuarioBD(), datos.getPassWdBD());
            return true;
        } catch (SQLException ex){
            Logger.getLogger(ConexionBDSimple.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("No se pudo establecer la conexion con la base de datos.");
            return false;
        }
    }

    @Override
    public void finalize(){
        try {
            if(!con.isClosed())
                con.close();
        } catch (SQLException ex) {
        } catch(NullPointerException ex){
        }
    }
}
