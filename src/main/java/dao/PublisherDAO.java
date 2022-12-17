package dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import entity.Publisher;

public class PublisherDAO {
    public List<Publisher> getAll(){
        List<Publisher> ans;
        try {
            ans = new ArrayList<>();
            Connection connection = MySQLConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM publisher";
            try (ResultSet rs = statement.executeQuery(query)) {
                while(rs.next()){
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String status = rs.getString("status");
                   
                    Publisher st = new Publisher(id, name, status);
                    ans.add(st);
                }
            }
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Publisher.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
}
