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
    
}
