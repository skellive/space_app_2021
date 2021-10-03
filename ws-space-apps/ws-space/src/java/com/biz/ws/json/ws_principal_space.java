/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.ws.json;

import com.biz.metodos.metodo_space_principal;
import java.io.IOException;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    @Path("/ws_listar_prueba/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ws_listar_prueba()
            throws JSONException, SQLException, IOException {

        List datos = new ArrayList();
        
        
        datos = listarPrueba();
        

        return Response.ok(response(datos), MediaType.APPLICATION_JSON).build();
    }
    
}



