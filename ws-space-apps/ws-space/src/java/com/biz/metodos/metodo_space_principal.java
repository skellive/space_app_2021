/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.metodos;

import com.biz.objetos.ObjBitacora;
import com.biz.objetos.ObjCabeceraBitacora;
import com.biz.objetos.ObjDetalleBitacora;
import com.biz.objetos.ObjPrueba;
import com.biz.objetos.ObjRol;
import com.biz.objetos.ObjUsuario;
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
    
       public List cabeceraBitacora(Integer userId, String token)throws SQLException {
        
        String resp = "";
        String sql = "";
        List<ObjCabeceraBitacora> lista = new ArrayList();
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection cn = null;
        CallableStatement cs = null;
        cn = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        ObjCabeceraBitacora obj = new ObjCabeceraBitacora();

        try {
            sql = "EXEC sp_cabecera_bitacora "+userId+ ",'"+token+"'";
            rs = jtc.execComand(cn, sql);
            if (rs != null) {
                while (rs.next()) {
                    obj = new ObjCabeceraBitacora();
                    obj.setId(rs.getInt(1));
                    obj.setUser_id(rs.getInt(2));
                    obj.setDate_modification(rs.getString(3));
                    obj.setTitle(rs.getString(4));
                    obj.setTags(rs.getString(5));
                    obj.setId_bitacora(rs.getInt(6));
                    obj.setState(rs.getString(7));
                    obj.setUrlDetalle("http://186.70.104.85:8080/ws-space/space/ws_principal_space/ws_listar_detalle_bitacora/"+userId+ "/"+obj.getId_bitacora()+"/"+token);

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
    
    
    
    public List detalleBitacora(Integer userId, Integer bitacoraId, String token)throws SQLException {
 
        
        
        String resp = "";
        String sql = "";
        List<ObjDetalleBitacora> lista = new ArrayList();
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection cn = null;
        CallableStatement cs = null;
        cn = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        ObjDetalleBitacora obj = new ObjDetalleBitacora();

        try {
            sql = "EXEC sp_detalle_bitacora "+userId+ ","+bitacoraId+",'"+token+"'";
            rs = jtc.execComand(cn, sql);
            if (rs != null) {
                while (rs.next()) {
                    obj = new ObjDetalleBitacora();
                    obj.setUser_id(rs.getInt(1));
                    obj.setDate_modification(rs.getString(2));
                    obj.setTitle(rs.getString(3));
                    obj.setTags(rs.getString(4));
                    obj.setId_bitacora(rs.getInt(5));
                    obj.setState(rs.getString(6));
                    obj.setId(rs.getInt(7));
                    obj.setResource(rs.getString(8));
                    obj.setType(rs.getString(10));

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
            
    
    
    public List<ObjUsuario> listarUser(String user, String passw, String token) {
        String resp = "";
        String sql = "";
        List<ObjUsuario> lista = new ArrayList();
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection cn = null;
        CallableStatement cs = null;
        cn = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        ObjUsuario obj = new ObjUsuario();

        try {
            sql = "EXEC crud_login 'SU', null , '"+user+"', '"+passw+"', null, '" + token + "', null, null, nul, null, null";
            rs = jtc.execComand(cn, sql);
            if (rs != null) {
                while (rs.next()) {
                    obj = new ObjUsuario();
                    obj.setIdUser(rs.getInt(1));
                    obj.setUser(rs.getString(2));
                    obj.setLast_login(rs.getString(3));
                    obj.setIs_login(rs.getString(4));
                    obj.setIs_super_user(rs.getString(5));
                    obj.setIs_banned(rs.getString(6));
                    obj.setDate_banned(rs.getString(7));
                    obj.setIdRol(rs.getInt(8));
                    obj.setName_rol(rs.getString(9));

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
    
    
    
    public String guardarBitacora(String opcion,Integer userId, String title, String description, String tags, Integer idBitacora, String state, String resource, String type, String token) {

        String resp = "";
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection con = null;
        CallableStatement cs = null;
        con = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();

        try {

            cs = con.prepareCall("{CALL crud_bitacora (?, ? , ?, ?, ?, ?, ?, ?, ?, ?,?)}");

            cs.setString(1, opcion);
            cs.setInt(2, userId);
            cs.setString(3, title);
            cs.setString(4, description);
            cs.setString(5, tags);
            cs.setInt(6, idBitacora);
            cs.setString(7, state);
            cs.setString(8, resource);
            cs.setString(9, type);
            cs.setString(10, token);
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
    
      public List<ObjBitacora> listarBitacora(Integer userId, Integer idBitacora, String token) {
        String resp = "";
        String sql = "";
        List<ObjBitacora> lista = new ArrayList();
        DataBase dataBase = new DataBase();
        ResultSet rs = null;
        Connection cn = null;
        CallableStatement cs = null;
        cn = dataBase.getConeccionSpaceApps();
        JTC jtc = new JTC();
        ObjBitacora obj = new ObjBitacora();

        try {
            sql = "EXEC  crud_bitacora 'AC','"+userId+"', null, null,null,"+ idBitacora+", null, null, null, '"+token+"', null";
            rs = jtc.execComand(cn, sql);
            if (rs != null) {
                while (rs.next()) {
                    obj = new ObjBitacora();
                    obj.setIdBitacora(rs.getInt(1));
                    obj.setUserId(rs.getInt(2));
                    obj.setDateModification(rs.getString(3));
                    obj.setTitle(rs.getString(4));
                    obj.setDescription(rs.getString(5));
                    obj.setTags(rs.getString(6));
                    obj.setIdBitacoraSecundario(rs.getInt(7));
                    obj.setState(rs.getString(8));
                    obj.setIdPrototipe(rs.getInt(9));
                    obj.setResource(rs.getString(10));
                    obj.setType(rs.getString(11));

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
