package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
    public static Connection create(){
        Connection connection = null;
        try {
            Driver myDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(myDriver);
            
            String DB_URL = "jdbc:mysql://localhost/book_store_g6";
            String USER = "root";
            String PASS = "12341234";
            
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
}
