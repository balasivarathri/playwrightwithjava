package architecture;

import lombok.extern.log4j.Log4j;

import java.sql.Connection;
//@Log4j
public class Dbconnections {

    private String dataBaseType = "";
    private String url = "";
    private String userName = "";
    private String password = "";

    public Connection getConnection(String dataBaseType, String url, String userName, String password){
        this.dataBaseType = dataBaseType;
        this.url = url;
        this.userName = userName;
        this.password = password;
        return getDatabaseConnection();
    }

    private Connection getDatabaseConnection(){
        return null;
    }

    public Connection getMorongwaConnection(){
        this.dataBaseType = "postgres";
        this.url = System.getProperty("morongwa.database.url");
        this.userName = System.getProperty("morongwa.database.username");
        this.password = System.getProperty("morongwa.database.password");
        return getDatabaseConnection();
    }
}
