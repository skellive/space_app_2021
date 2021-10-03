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
public class ObjBitacora {
    
    private Integer idBitacora;
    private Integer userId;
    private String dateModification;
    private String title;
    private String description;
    private String tags;
    private Integer idBitacoraSecundario;
    private String state;
    private Integer idPrototipe;
    private String resource;
    private String type;

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    
    
    public String getDateModification() {
        return dateModification;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Integer getIdBitacoraSecundario() {
        return idBitacoraSecundario;
    }

    public void setIdBitacoraSecundario(Integer idBitacoraSecundario) {
        this.idBitacoraSecundario = idBitacoraSecundario;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getIdPrototipe() {
        return idPrototipe;
    }

    public void setIdPrototipe(Integer idPrototipe) {
        this.idPrototipe = idPrototipe;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    //convert to jsonObject
    public String toJson(){
        String json = "{";
        json += "\"idBitacora\":\""+this.idBitacora+"\",";
        json += "\"userId\":\""+this.userId+"\",";
        json += "\"dateModification\":\""+this.dateModification+"\",";
        json += "\"title\":\""+this.title+"\",";
        json += "\"description\":\""+this.description+"\",";
        json += "\"tags\":\""+this.tags+"\",";
        json += "\"idBitacoraSecundario\":\""+this.idBitacoraSecundario+"\",";
        json += "\"state\":\""+this.state+"\",";
        json += "\"idPrototipe\":\""+this.idPrototipe+"\",";
        json += "\"resource\":\""+this.resource+"\",";
        json += "\"type\":\""+this.type+"\"";
        json += "}";
        return json;
    }
    
    
}
