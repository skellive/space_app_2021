
package com.biz.metodos;

import com.microsoft.sqlserver.jdbc.SQLServerConnectionPoolDataSource;
import java.sql.BatchUpdateException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBase {

    org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DataBase.class.getName());
    SQLServerConnectionPoolDataSource pool = null;

    /* Proceso: Metodo de conexión a la base principal de CERTUS
     * @return Connection resultado de la conexión;*/
    public Connection getConeccionMaster() {
        Connection conn = null;
        try {
            pool = new SQLServerConnectionPoolDataSource();
            String dbURL = "jdbc:sqlserver://172.16.1.183;databaseName=BD_PHARMACYS";
            String user = "sa";
            String pass = "Nutri2008";
            
            pool.setUser(user);
            pool.setPassword(pass);
            pool.setURL(dbURL);
            pool.setLockTimeout(30000);
            conn = pool.getConnection();
            if (conn != null) {
                log.info("getConeccionMaster: Conexion abierta BD_CERTUS");
            } else {
                log.info("getConeccionMaster: Problemas de conexion BD_CERTUS");
            }
        } catch (Exception ex) {
            log.error("getConeccionMaster: " + ex.toString());
            ex.printStackTrace();
        }
        return conn;
    }
    
    
    
    
    public Connection getConeccionSpaceApps() {
        Connection conn = null;
        try {
            pool = new SQLServerConnectionPoolDataSource();
            String dbURL = "jdbc:sqlserver://172.16.1.9;databaseName=SPACE_APPS_BITACORA";
            String user = "sa";
            String pass = "Nutri2008";
            
            pool.setUser(user);
            pool.setPassword(pass);
            pool.setURL(dbURL);
            pool.setLockTimeout(30000);
            conn = pool.getConnection();
            if (conn != null) {
                log.info("getConeccionMaster: Conexion abierta BD_CERTUS");
            } else {
                log.info("getConeccionMaster: Problemas de conexion BD_CERTUS");
            }
        } catch (Exception ex) {
            log.error("getConeccionMaster: " + ex.toString());
            ex.printStackTrace();
        }
        return conn;
    }
        
        
   

    public Connection getConeccionINFOBI() {
        Connection conn = null;
        try {
            pool = new SQLServerConnectionPoolDataSource();
            String dbURL = "jdbc:sqlserver://172.16.1.2;databaseName=INFOBI";
            String user = "sa";
            String pass = "Server2020*";

            pool.setUser(user);
            pool.setPassword(pass);
            pool.setURL(dbURL);
            pool.setLockTimeout(30000);
            conn = pool.getConnection();

            if (conn != null) {
                log.info("getConeccionMaster: Conexion abierta BD_CERTUS");
            } else {
                log.info("getConeccionMaster: Problemas de conexion BD_CERTUS");
            }
        } catch (Exception ex) {
            log.error("getConeccionMaster: " + ex.toString());
        }
        return conn;
    }

}
