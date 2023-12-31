package Database;

import Properties.DBProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConn {
    private  static   Connection controlConn;



    public static   Connection connectToControl() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = DBProperties.getControlURL();
            String user = DBProperties.getControlUsername();
            String pass = DBProperties.getControlPassword();
            controlConn = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connected to Control");
        } catch (Exception e) {

        }
        return controlConn;
    }

    public  Connection getControlConn() {
        return controlConn;
    }

    public void closeControl() {
        try {
            if(controlConn != null) {
                controlConn.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



}
