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
public class ObjCabeceraBitacora {
    
    
    
    private Integer id;
    private Integer user_id; 
    private String date_modification;
    private String title;
    private String tags;
    private Integer id_bitacora;
    private String state;
    private String urlDetalle;

    public String getUrlDetalle() {
        return urlDetalle;
    }

    public void setUrlDetalle(String urlDetalle) {
        this.urlDetalle = urlDetalle;
    }
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getDate_modification() {
        return date_modification;
    }

    public void setDate_modification(String date_modification) {
        this.date_modification = date_modification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getId_bitacora() {
        return id_bitacora;
    }

    public void setId_bitacora(Integer id_bitacora) {
        this.id_bitacora = id_bitacora;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    
    
    
    
    
    
}
