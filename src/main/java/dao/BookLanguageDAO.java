/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.BookLanguage;
import util.XJdbc;
import java.util.*;
import java.sql.*;

/**
 *
 * @author DELL
 */
public class BookLanguageDAO extends SystemDAO<BookLanguage, Long> {

    private static final String TABLE_BOOK_LANGUAGE = "book_language";

    private static final String COLUMN_ID = "language_id";
    private static final String COLUMN_LANGUAGE_CODE = "language_code";
    private static final String COLUMN_LANGUAGE_NAME = "language_name";

    @Override
    public void create(BookLanguage bl) {
        String sql = "INSERT INTO " + TABLE_BOOK_LANGUAGE + " (" + COLUMN_LANGUAGE_CODE + ", " + COLUMN_LANGUAGE_NAME + ") VALUES (?, ?)";
        XJdbc.update(sql, bl.getLanguage_code(), bl.getLanguage_name());
    }

    @Override
    public void update(BookLanguage bl) {
        String sql = "UPDATE " + TABLE_BOOK_LANGUAGE + " SET " + COLUMN_LANGUAGE_CODE + "=?, " + COLUMN_LANGUAGE_NAME + "=?" + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, bl.getLanguage_code(), bl.getLanguage_name());
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM " + TABLE_BOOK_LANGUAGE + " WHERE " + COLUMN_ID + " = ?";
        XJdbc.update(sql, id);
    }

    @Override
    public List<BookLanguage> getAll() {
        String sql = "SELECT * FROM " + TABLE_BOOK_LANGUAGE;
        return this.getBySql(sql);
    }

    @Override
    public BookLanguage getById(Long id) {
        String sql = "SELECT * FROM " + TABLE_BOOK_LANGUAGE + " WHERE " + COLUMN_ID + " = ?";
        List<BookLanguage> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<BookLanguage> getBySql(String sql, Object... args) {
        List<BookLanguage> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {
                BookLanguage entity = new BookLanguage();
                entity.setLanguage_id(rs.getLong(COLUMN_ID));
                entity.setLanguage_code(rs.getString(COLUMN_LANGUAGE_CODE));
                entity.setLanguage_name(rs.getString(COLUMN_LANGUAGE_NAME));
                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
