/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.metodos;

import com.biz.objetos.ObjPrueba;
import com.biz.objetos.ObjRol;
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

    public List listarRol(String token) {
        String resp = "";
        String sql = "";
        List lista = new ArrayList();
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection cn = null;
        CallableStatement cs = null;
        cn = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        ObjRol obj = new ObjRol();

        try {
            sql = "EXEC crud_login 'CR', null , null, null, null, '" + token + "', null, null, nul, null, null";
            rs = jtc.execComand(cn, sql);
            if (rs != null) {
                while (rs.next()) {
                    obj = new ObjRol();
                    obj.setIdRol(rs.getInt(1));
                    obj.setNameRol(rs.getString(2));
                    obj.setState(rs.getString(3));

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

    public String dataRol(String nameRol, String token) {
        String resp = "";
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();

        try {

            cs = con.prepareCall("{CALL crud_login (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cs.setString(1, "IU");
            cs.setInt(2, 0);
            cs.setString(3, "null");
            cs.setString(4, "null");
            cs.setString(5, "null");
            cs.setString(6, token);
            cs.setString(7, "null");
            cs.setInt(8, 0);
            cs.setString(9, nameRol);
            cs.setString(10, "null");
            cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            cs.execute();
            resp = cs.getString(11);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    public String actualizaRol(Integer idRol, String nameRol, String state, String token) {
        String resp = "";
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();

        try {

            cs = con.prepareCall("{CALL crud_login (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cs.setString(1, "IU");
            cs.setInt(2, 0);
            cs.setString(3, "null");
            cs.setString(4, "null");
            cs.setString(5, "null");
            cs.setString(6, token);
            cs.setString(7, "null");
            cs.setInt(8, idRol);
            cs.setString(9, nameRol);
            cs.setString(10, state);
            cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            cs.execute();
            resp = cs.getString(11);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    public String loguinUser(String user, String password, String tokenLoguin) {
        String resp = "";
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();

        try {
            System.out.println("Pass: " + password);

            cs = con.prepareCall("{CALL login_space (?, ? , ?, ?)}");

            cs.setString(1, user);
            cs.setString(2, password);
            cs.setString(3, tokenLoguin);
            cs.registerOutParameter(4, java.sql.Types.VARCHAR);
            cs.execute();
            resp = cs.getString(4);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    public String dataUsuario(String usuario, String passw, Integer idRol, String token) {

        String resp = "";
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();

        try {

            cs = con.prepareCall("{CALL crud_login (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cs.setString(1, "IU");
            cs.setInt(2, 0);
            cs.setString(3, usuario);
            cs.setString(4, passw);
            cs.setString(5, "null");
            cs.setString(6, token);
            cs.setString(7, "null");
            cs.setInt(8, idRol);
            cs.setString(9, "null");
            cs.setString(10, "null");
            cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            cs.execute();
            resp = cs.getString(11);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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

    public String actualizaUsuario(Integer idUser, String usuario, String passw, Integer idRol, String token, String superUser, String isBanned) {

        String resp = "";
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();

        try {

            cs = con.prepareCall("{CALL crud_login (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)}");

            cs.setString(1, "UU");
            cs.setInt(2, idUser);
            cs.setString(3, usuario);
            cs.setString(4, passw);
            cs.setString(5, superUser);
            cs.setString(6, token);
            cs.setString(7, isBanned);
            cs.setInt(8, idRol);
            cs.setString(9, "null");
            cs.setString(10, "null");
            cs.registerOutParameter(11, java.sql.Types.VARCHAR);
            cs.execute();
            resp = cs.getString(11);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
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
