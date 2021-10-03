/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.ws.json;

import com.biz.metodos.metodo_space_principal;
import com.java.MetodoHash.hash;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.Status.PRECONDITION_FAILED;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author sistemas01
 */

@Path("/ws_principal_space")
public class ws_principal_space extends metodo_space_principal{
    
    
     JsonObject objson;

    private JsonObject ConverObjJson(String data) {
        JsonReader jsonReader = Json.createReader(new StringReader(data));
        JsonObject objsonf = jsonReader.readObject();
        return objsonf;
    }

    private String response(List array) {
        JSONArray lista = new JSONArray();
        lista.put(array);
        String resp = lista.toString().substring(1, lista.toString().length() - 1);

        return resp;
    }

    private String response(String data) throws JSONException {
        JSONObject obj = new JSONObject();
        obj.put("respuesta", data);
        return obj.toString();
    }
    
    
    /// Link: http://localhost:8080/ws-space/space/ws_principal_space/ws_listar_prueba
       @GET
    @Path("/ws_listar_rol/{token}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ws_listar_rol(@PathParam("token")String token)
            throws JSONException, SQLException, IOException {

        List datos = new ArrayList();
        
        
        datos = listarRol(token);
        

        return Response.ok(response(datos), MediaType.APPLICATION_JSON).build();
    }
    
    
     @POST
    @Path("/ws_guardar_usuario")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response ws_guardar_usuario(String data) throws SQLException, JSONException {
        objson = ConverObjJson(data);

        String resp = "";

        try {
            
            
            resp = dataUsuario(objson.getString("usuario"), hash.sha1(objson.getString("password")), objson.getInt("idRol"), objson.getString("token"));

            return Response.ok(response(resp), APPLICATION_JSON).status(OK).build();
        } catch (JSONException e) {
            resp = String.valueOf( Response.status(500));
            e.printStackTrace();
        }
       return Response.ok(response(resp), APPLICATION_JSON).status(PRECONDITION_FAILED).build();
    }
    
    
    
     @POST
    @Path("/ws_guardar_rol")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response ws_guardar_rol(String data) throws SQLException, JSONException {
        objson = ConverObjJson(data);

        String resp = "";

        try {
            
            
            resp = dataRol(objson.getString("nameRol"), objson.getString("token"));

            return Response.ok(response(resp), APPLICATION_JSON).status(OK).build();
        } catch (JSONException e) {
            resp = String.valueOf( Response.status(500));
            e.printStackTrace();
        }
       return Response.ok(response(resp), APPLICATION_JSON).status(PRECONDITION_FAILED).build();
    }
    
    
     @POST
    @Path("/ws_actualiza_rol")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response ws_actualiza_rol(String data) throws SQLException, JSONException {
        objson = ConverObjJson(data);

        String resp = "";

        try {
            
            
            resp = actualizaRol(objson.getInt("idRol"), objson.getString("nameRol"), objson.getString("state"), objson.getString("token"));

            return Response.ok(response(resp), APPLICATION_JSON).status(OK).build();
        } catch (JSONException e) {
            resp = String.valueOf( Response.status(500));
            e.printStackTrace();
        }
       return Response.ok(response(resp), APPLICATION_JSON).status(PRECONDITION_FAILED).build();
    }
    
    
    
      
     @POST
    @Path("/ws_actualiza_usuario")
    @Consumes(APPLICATION_JSON)
    @Produces(APPLICATION_JSON)
    public Response ws_actualiza_usuario(String data) throws SQLException, JSONException {
        objson = ConverObjJson(data);

        String resp = "";

        try {
            
            
            resp = actualizaUsuario(objson.getInt("idUser"),objson.getString("usuario"), hash.sha1(objson.getString("password")), objson.getInt("idRol"), objson.getString("token"),objson.getString("superUser"),objson.getString("isBanned"));

            return Response.ok(response(resp), APPLICATION_JSON).status(OK).build();
        } catch (JSONException e) {
            resp = String.valueOf( Response.status(500));
            e.printStackTrace();
        }
       return Response.ok(response(resp), APPLICATION_JSON).status(PRECONDITION_FAILED).build();
    }
    
    
    
    
}



