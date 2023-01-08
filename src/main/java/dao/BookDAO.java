/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.XJdbc;
import entity.Book;
import java.util.ArrayList;
import java.util.List;
import enumeration.*;
import entity.*;

/**
 *
 * @author Huy
 */
public class BookDAO extends SystemDAO<Book, Long> {

    private static final String TABLE_BOOK = "book";
    private static final String TABLE_BOOK_CATEGORY = "book_category";
    private static final String TABLE_BOOK_LANGUAGE = "book_language";
    private static final String TABLE_AUTHOR = "author";
    private static final String TABLE_PUBLISHER = "publisher";

    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "title";
    private static final String COLUMN_ISBN13 = "isbn13";
    private static final String COLUMN_LANGUAGE_ID = "language_id";
    private static final String COLUMN_NUMPAGES = "num_pages";
    private static final String COLUMN_PUBLISHER_ID = "publisher_id";
    private static final String COLUMN_CATEGORY_ID = "category_id";
    private static final String COLUMN_AUTHOR_ID = "author_id";
    private static final String COLUMN_PUBLISHED_DATE = "published_date";
    private static final String COLUMN_STOCK = "stock";
    private static final String COLUMN_STATUS = "status";
    private static final String COLUMN_PRICE = "price";

    public void create(Book book) {
        String sql = "INSERT INTO " + TABLE_BOOK + " (" + COLUMN_TITLE + ", " + COLUMN_ISBN13 + ", " + COLUMN_LANGUAGE_ID + ", " + COLUMN_NUMPAGES + ", " + COLUMN_PUBLISHER_ID + ", " + COLUMN_CATEGORY_ID + ", " + COLUMN_AUTHOR_ID + ", " + COLUMN_PUBLISHED_DATE + ", " + COLUMN_STOCK + ", " + COLUMN_STATUS + ", " + COLUMN_PRICE + ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        XJdbc.update(sql, book.getTitle(), book.getIsbn13(), book.getBookLanguage().getLanguage_id(), book.getNumPages(), book.getPublisher().getId(), book.getCategory().getId(), book.getAuthor().getId(), java.sql.Date.valueOf(book.getPublishedDate()), book.getStock(), book.getStatus().name(), book.getPrice());
    }

    @Override
    public void update(Book entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void updateStatusWithCondition(String status, String conditionColumn, String condition) {
        String sql = "UPDATE " + TABLE_BOOK + " SET " + COLUMN_STATUS + " = ? WHERE " + conditionColumn + " = ?";
        XJdbc.update(sql, status, condition);
    }

    @Override
    public void delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Book> getAll() {
        String sql = "SELECT "
                + TABLE_BOOK + ".id, "
                + TABLE_BOOK + ".title, "
                + TABLE_BOOK + ".isbn13, "
                + TABLE_BOOK + ".language_id, "
                + TABLE_BOOK + ".num_pages, "
                + TABLE_BOOK + ".publisher_id, "
                + TABLE_BOOK + ".category_id, "
                + TABLE_BOOK + ".author_id, "
                + TABLE_BOOK + ".published_date, "
                + TABLE_BOOK + ".stock, "
                + TABLE_BOOK + ".status, "
                + TABLE_BOOK + ".price, "
                + TABLE_BOOK_CATEGORY + ".name as book_category_name, "
                + TABLE_BOOK_CATEGORY + ".status as book_category_status, "
                + TABLE_BOOK_LANGUAGE + ".language_code as book_language_code, "
                + TABLE_BOOK_LANGUAGE + ".language_name as book_language_name, "
                + TABLE_AUTHOR + ".name as author_name, "
                + TABLE_AUTHOR + ".status as author_status, "
                + TABLE_PUBLISHER + ".name as publisher_name, "
                + TABLE_PUBLISHER + ".status as publisher_status "
                + "FROM " + TABLE_BOOK
                + " INNER JOIN " + TABLE_BOOK_CATEGORY + " ON " + TABLE_BOOK_CATEGORY + ".id = " + TABLE_BOOK + ".category_id"
                + " INNER JOIN " + TABLE_BOOK_LANGUAGE + " ON " + TABLE_BOOK_LANGUAGE + ".language_id = " + TABLE_BOOK + ".language_id"
                + " INNER JOIN " + TABLE_AUTHOR + " ON " + TABLE_AUTHOR + ".id = " + TABLE_BOOK + ".author_id"
                + " INNER JOIN " + TABLE_PUBLISHER + " ON " + TABLE_PUBLISHER + ".id = " + TABLE_BOOK + ".publisher_id"
                + " ORDER BY id";

        return this.getBySql(sql);
    }
    public List<Book> getOutOfStock() {
        String sql = "SELECT "
                + TABLE_BOOK + ".id, "
                + TABLE_BOOK + ".title, "
                + TABLE_BOOK + ".isbn13, "
                + TABLE_BOOK + ".language_id, "
                + TABLE_BOOK + ".num_pages, "
                + TABLE_BOOK + ".publisher_id, "
                + TABLE_BOOK + ".category_id, "
                + TABLE_BOOK + ".author_id, "
                + TABLE_BOOK + ".published_date, "
                + TABLE_BOOK + ".stock, "
                + TABLE_BOOK + ".status, "
                + TABLE_BOOK + ".price, "
                + TABLE_BOOK_CATEGORY + ".name as book_category_name, "
                + TABLE_BOOK_CATEGORY + ".status as book_category_status, "
                + TABLE_BOOK_LANGUAGE + ".language_code as book_language_code, "
                + TABLE_BOOK_LANGUAGE + ".language_name as book_language_name, "
                + TABLE_AUTHOR + ".name as author_name, "
                + TABLE_AUTHOR + ".status as author_status, "
                + TABLE_PUBLISHER + ".name as publisher_name, "
                + TABLE_PUBLISHER + ".status as publisher_status "
                + "FROM " + TABLE_BOOK
                + " INNER JOIN " + TABLE_BOOK_CATEGORY + " ON " + TABLE_BOOK_CATEGORY + ".id = " + TABLE_BOOK + ".category_id"
                + " INNER JOIN " + TABLE_BOOK_LANGUAGE + " ON " + TABLE_BOOK_LANGUAGE + ".language_id = " + TABLE_BOOK + ".language_id"
                + " INNER JOIN " + TABLE_AUTHOR + " ON " + TABLE_AUTHOR + ".id = " + TABLE_BOOK + ".author_id"
                + " INNER JOIN " + TABLE_PUBLISHER + " ON " + TABLE_PUBLISHER + ".id = " + TABLE_BOOK + ".publisher_id"
                + " WHERE " + TABLE_BOOK + ".stock <= 0"
                + " ORDER BY id";

        return this.getBySql(sql);
    }

    public List<Book> get10LastedBooks() {
        String sql = "SELECT "
                + TABLE_BOOK + ".id, "
                + TABLE_BOOK + ".title, "
                + TABLE_BOOK + ".isbn13, "
                + TABLE_BOOK + ".language_id, "
                + TABLE_BOOK + ".num_pages, "
                + TABLE_BOOK + ".publisher_id, "
                + TABLE_BOOK + ".category_id, "
                + TABLE_BOOK + ".author_id, "
                + TABLE_BOOK + ".published_date, "
                + TABLE_BOOK + ".stock, "
                + TABLE_BOOK + ".status, "
                + TABLE_BOOK + ".price, "
                + TABLE_BOOK_CATEGORY + ".name as book_category_name, "
                + TABLE_BOOK_CATEGORY + ".status as book_category_status, "
                + TABLE_BOOK_LANGUAGE + ".language_code as book_language_code, "
                + TABLE_BOOK_LANGUAGE + ".language_name as book_language_name, "
                + TABLE_AUTHOR + ".name as author_name, "
                + TABLE_AUTHOR + ".status as author_status, "
                + TABLE_PUBLISHER + ".name as publisher_name, "
                + TABLE_PUBLISHER + ".status as publisher_status "
                + "FROM " + TABLE_BOOK
                + " INNER JOIN " + TABLE_BOOK_CATEGORY + " ON " + TABLE_BOOK_CATEGORY + ".id = " + TABLE_BOOK + ".category_id"
                + " INNER JOIN " + TABLE_BOOK_LANGUAGE + " ON " + TABLE_BOOK_LANGUAGE + ".language_id = " + TABLE_BOOK + ".language_id"
                + " INNER JOIN " + TABLE_AUTHOR + " ON " + TABLE_AUTHOR + ".id = " + TABLE_BOOK + ".author_id"
                + " INNER JOIN " + TABLE_PUBLISHER + " ON " + TABLE_PUBLISHER + ".id = " + TABLE_BOOK + ".publisher_id"
                + " ORDER BY published_date DESC"
                + " LIMIT 10";

        return this.getBySql(sql);
    }

    @Override
    public Book getById(Long id) {
        String sql = "SELECT * FROM " + TABLE_BOOK + " WHERE " + COLUMN_ID + " = ?";
        List<Book> list = this.getBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    protected List<Book> getBySql(String sql, Object... args) {
        List<Book> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while (rs.next()) {

                Book entity = new Book();
                entity.setId(rs.getLong(COLUMN_ID));
                entity.setTitle(rs.getString(COLUMN_TITLE));
                entity.setIsbn13(rs.getString(COLUMN_ISBN13));
                entity.setNumPages(rs.getInt(COLUMN_NUMPAGES));
                entity.setPublishedDate(rs.getDate(COLUMN_PUBLISHED_DATE).toLocalDate());
                entity.setStock(rs.getInt(COLUMN_STOCK));
                entity.setStatus(BookStatus.valueOf(rs.getString(COLUMN_STATUS)));
                entity.setPrice(rs.getDouble(COLUMN_PRICE));

                BookLanguage bookLanguage = new BookLanguage(rs.getLong("language_id"), rs.getString("book_language_code"), rs.getString("book_language_name"));
                Publisher publisher = new Publisher(rs.getLong("publisher_id"), rs.getString("publisher_name"), PublisherStatus.valueOf(rs.getString("publisher_status")));
                Category category = new Category(rs.getLong("category_id"), rs.getString("book_category_name"), CategoryStatus.valueOf(rs.getString("book_category_status")));
                Author author = new Author(rs.getLong("author_id"), rs.getString("author_name"), AuthorStatus.valueOf(rs.getString("author_status")));

                entity.setBookLanguage(bookLanguage);
                entity.setPublisher(publisher);
                entity.setCategory(category);
                entity.setAuthor(author);

                list.add(entity);
            }
            rs.getStatement().close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public int countByColumn(String collumn, String value) {
        String sql = "SELECT COUNT(id) AS count FROM " + TABLE_BOOK + " WHERE " + collumn + " = ?";
        try {
            ResultSet rs = XJdbc.query(sql, value);
            while (rs.next()) {
                return rs.getInt("count");
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
