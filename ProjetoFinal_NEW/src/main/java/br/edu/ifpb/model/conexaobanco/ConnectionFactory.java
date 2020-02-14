package br.edu.ifpb.model.conexaobanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private String usuario;
    private String url;
    private String senha;

    public ConnectionFactory(){
        usuario ="postgres";
       senha = "daniel";

        url = "jdbc:postgresql://localhost:5432/CantinaJsf";
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(url,usuario,senha);
    }


}
