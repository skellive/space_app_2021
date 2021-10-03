/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.metodos;


import com.biz.objetos.ObjPrueba;
import com.jtc.JTC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sistemas01
 */
public class metodo_space_principal {
    
    
    
    public List listarPrueba() {
        String resp = "";
        String sql = "";
        List lista = new ArrayList();
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection cn = null;
        CallableStatement cs = null;
        cn = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        ObjPrueba obj = new ObjPrueba();
      
        try {
            sql = "EXEC sp_prueba ";
            rs = jtc.execComand(cn, sql);
            if (rs != null) {
                while (rs.next()) {
                   obj = new ObjPrueba();
                    obj.setDatos1(rs.getString(1));
                    obj.setDato2(rs.getString(2));
                    
                    lista.add(obj);
                }
            } else {
                lista = null;
            }
        } catch (SQLException ex) {
            lista = null;
            ex.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                cn.close();
            } catch (Exception e) {
            }
        }

        return lista;

    }
    
    
    public String dataUsuario(String usuario, String passw, Integer idRol,String token){
        
        String resp="";
        DataBase dataBase = new DataBase();
        ResultSet  rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        
        try{
            
              cs = con.prepareCall("{CALL crud_login (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
              
              cs.setString(1, "IU");
              cs.setString(2, "null");
              cs.setString(3, usuario);
              cs.setString(4, passw);
              cs.setString(5, "null");
              cs.setString(6, token);
              cs.setString(7, "null");
              cs.setString(8, "null");
              cs.setString(9, "null");
              cs.setString(10, "null");
                 cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            cs.execute();
            resp = cs.getString(11);
              
              
        }catch(Exception e){
           e.printStackTrace();
        }finally {
            try {
                rs.close();
            } catch (Exception e) {
            }
            try {
                con.close();
            } catch (Exception e) {
            }
        }
        
        
        return resp;
    }
    
    
}
