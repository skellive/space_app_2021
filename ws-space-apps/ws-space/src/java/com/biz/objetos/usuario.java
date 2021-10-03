/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biz.objetos;

/**
 *
 * @author User
 */
public class usuario 
{
    private int id_usuario;
    private String tipo_identificacion;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String estado;
    private String fecha_registro;
    private String tipo_usuario;
    private int id_perfil;

    public usuario()
    {
        this.id_usuario = 0;
        this.tipo_identificacion = "";
        this.identificacion = "";
        this.nombre = "";
        this.apellido = "";
        this.correo = "";
        this.contrasena = "";
        this.estado = "";
        this.fecha_registro = "";
        this.tipo_usuario = "";
        this.id_perfil = 0;
    }

    public usuario(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }
    
    
    public usuario( int id_usuario, String tipo_identificacion, String identificacion, 
                    String nombre, String apellido, String correo, String contrasena, 
                    String estado, String fecha_registro, String tipo_usuario, int id_perfil )
    {
        this.id_usuario = id_usuario;
        this.tipo_identificacion = tipo_identificacion;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
        this.estado = estado;
        this.fecha_registro = fecha_registro;
        this.tipo_usuario = tipo_usuario;
        this.id_perfil = id_perfil;
    }
    
    
    /**
     * @return the id_usuario
     */
    public int getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    /**
     * @return the tipo_identificacion
     */
    public String getTipo_identificacion() {
        return tipo_identificacion;
    }

    /**
     * @param tipo_identificacion the tipo_identificacion to set
     */
    public void setTipo_identificacion(String tipo_identificacion) {
        this.tipo_identificacion = tipo_identificacion;
    }

    /**
     * @return the identificacion
     */
    public String getIdentificacion() {
        return identificacion;
    }

    /**
     * @param identificacion the identificacion to set
     */
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the apellido
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the fecha_registro
     */
    public String getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    /**
     * @return the tipo_usuario
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }

    /**
     * @param tipo_usuario the tipo_usuario to set
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }

    /**
     * @return the id_perfil
     */
    public int getId_perfil() {
        return id_perfil;
    }

    /**
     * @param id_perfil the id_perfil to set
     */
    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
    
    
}
