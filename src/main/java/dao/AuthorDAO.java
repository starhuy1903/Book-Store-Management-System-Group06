package dao;

import entity.Author;
import enumeration.AuthorStatus;
import java.sql.*;
import java.util.*;
import util.XJdbc;

public class AuthorDAO extends SystemDAO<Author, Long> {
    
    private static final String TABLE_AUTHOR = "author";
    
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STATUS = "status";
    
    @Override
    public void create(Author author) {
        String sql = "INSERT INTO " + TABLE_AUTHOR + " (" + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES (?, ?)";
        XJdbc.update(sql, author.getName(),author.getStatus().name());
    }
    
    @Override
    public void update(Author author) {
        String sql = "UPDATE " + TABLE_AUTHOR + " SET " + COLUMN_NAME + "=?, " + COLUMN_STATUS + "=?"+ " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, author.getName(),author.getStatus().name(),author.getId());
    }
    
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_AUTHOR + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }
    
    @Override
    public List<Author> getAll(){
        String sql = "SELECT * FROM " + TABLE_AUTHOR;
        return this.getBySql(sql);
    }
    
    @Override
    public Author getById(Long id){
        String sql = "SELECT * FROM " + TABLE_AUTHOR + " WHERE " + COLUMN_ID + " = ?";
        List<Author> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }
    
    @Override
    protected List<Author> getBySql(String sql, Object... args) {
        List<Author> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Author entity = new Author();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setStatus(AuthorStatus.valueOf(rs.getString(COLUMN_STATUS)));
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
