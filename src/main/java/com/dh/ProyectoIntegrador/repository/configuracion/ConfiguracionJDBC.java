package com.dh.ProyectoIntegrador.repository.configuracion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfiguracionJDBC {

    private String jdbcDriver;
    private String dbUrl;
    private String username;
    private String password;

    public ConfiguracionJDBC() {
        this.jdbcDriver="org.h2.Driver";
        this.dbUrl = "jdbc:h2:~/db_clinica-test;DB_CLOSE_DELAY=-1;INIT=RUNSCRIPT FROM 'createOdontology.sql'";
        this.username = "root";
        this.password ="1234";
    }

    public Connection conexion(){
        Connection con = null;
        try {
            Class.forName(jdbcDriver);
            con= DriverManager.getConnection(dbUrl,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
