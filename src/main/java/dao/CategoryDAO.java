package dao;

import entity.Category;
import java.sql.*;
import java.util.*;
import enumeration.CategoryStatus;
import util.XJdbc;

public class CategoryDAO extends SystemDAO<Category, Long> {
    
    private static final String TABLE_CATEGORY = "book_category";
    
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_STATUS = "status";
    
    @Override
    public void create(Category category) {
        String sql = "INSERT INTO " + TABLE_CATEGORY + " (" + COLUMN_NAME + ", " + COLUMN_STATUS + ") VALUES (?, ?)";
        XJdbc.update(sql, category.getName(),category.getStatus().name());
    }
    
    @Override
    public void update(Category category) {
        String sql = "UPDATE " + TABLE_CATEGORY + " SET " + COLUMN_NAME + "=?, " + COLUMN_STATUS + "=?"+ " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, category.getName(),category.getStatus().name(),category.getId());
    }
    
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_CATEGORY + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }
    
    @Override
    public List<Category> getAll(){
        String sql = "SELECT * FROM " + TABLE_CATEGORY;
        return this.getBySql(sql);
    }
    
    @Override
    public Category getById(Long id){
        String sql = "SELECT * FROM " + TABLE_CATEGORY + " WHERE " + COLUMN_ID + " = ?";
        List<Category> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }
    
    @Override
    protected List<Category> getBySql(String sql, Object... args) {
        List<Category> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                Category entity = new Category();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setName(rs.getString(COLUMN_NAME));
                entity.setStatus(CategoryStatus.valueOf(rs.getString(COLUMN_STATUS)));
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
