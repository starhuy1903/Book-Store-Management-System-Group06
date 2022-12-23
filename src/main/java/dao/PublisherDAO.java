package dao;

import java.sql.*;
import java.util.*;
import entity.Publisher;
import enumeration.PublisherStatus;
import util.XJdbc;

public class PublisherDAO extends SystemDAO<Publisher, Long> {
    
    private static final String TABLE_PUBLISHER = "publisher";
    
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STATUS = "status";
    
    @Override
    public void create(Publisher publisher) {
        String sql = "INSERT INTO " + TABLE_PUBLISHER + " (" + COLUMN_ID + ", " + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES (?, ?, ?)";
        XJdbc.update(sql, publisher.getId(), publisher.getName(),publisher.getStatus());
    }
    
    @Override
    public void update(Publisher publisher) {
        String sql = "UPDATE " + TABLE_PUBLISHER + " SET " + COLUMN_NAME + "=?, " + COLUMN_STATUS + "=?";
        XJdbc.update(sql, publisher.getName(),publisher.getStatus());
    }
    
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_PUBLISHER + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }
    
    @Override
    public List<Publisher> getAll(){
        String sql = "SELECT * FROM " + TABLE_PUBLISHER;
        return this.getBySql(sql);
    }
    
    @Override
    public Publisher getById(Long id){
        String sql = "SELECT * FROM " + TABLE_PUBLISHER + " WHERE " + COLUMN_ID + " = ?";
        List<Publisher> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }
    
    @Override
    protected List<Publisher> getBySql(String sql, Object... args) {
        List<Publisher> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Publisher entity = new Publisher();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setStatus(PublisherStatus.valueOf(rs.getString(COLUMN_STATUS)));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
