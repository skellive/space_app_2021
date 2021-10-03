/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.objetos;

/**
 *
 * @author sistemas01
 */
public class ObjUsuario {
    
    private Integer idUser;
    private String user;
    private String last_login;
    private String is_login;
    private String is_super_user;
    private String is_banned;
    private String date_banned;
    private Integer idRol;
    private String name_rol;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public String getIs_login() {
        return is_login;
    }

    public void setIs_login(String is_login) {
        this.is_login = is_login;
    }

    public String getIs_super_user() {
        return is_super_user;
    }

    public void setIs_super_user(String is_super_user) {
        this.is_super_user = is_super_user;
    }

    public String getIs_banned() {
        return is_banned;
    }

    public void setIs_banned(String is_banned) {
        this.is_banned = is_banned;
    }

    public String getDate_banned() {
        return date_banned;
    }

    public void setDate_banned(String date_banned) {
        this.date_banned = date_banned;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public String getName_rol() {
        return name_rol;
    }

    public void setName_rol(String name_rol) {
        this.name_rol = name_rol;
    }
    
    
    
    
    
}
