package controller;

import dao.BookDAO;
import entity.Book;
import enumeration.PublisherStatus;
import java.util.*;

public class BookController {

    public List<Book> getAll() {
        BookDAO bd = new BookDAO();
        return bd.getAll();
    }
    
    public List<Book> getOutOfStock() {
        BookDAO bd = new BookDAO();
        return bd.getOutOfStock();
    }
    
    public List<Book> getLatestBooks() {
        BookDAO bd = new BookDAO();
        return bd.get10LastedBooks();
    }
    
    public void create(Book book){
        BookDAO bd = new BookDAO();
        bd.create(book);
    }
    
    public void edit(Book publisher) {
        BookDAO pd = new BookDAO();  
        pd.update(publisher);
    }

    public void editMany(List<Book> list) {
        for (Book book : list) {
            edit(book);
        }
    }

    public boolean delete(Long id) {
        BookDAO bd = new BookDAO();
        
        bd.delete(id);
        return true;
    }
    
    public void deleteMany(List<Long> list) {
        for (Long id : list) {
            delete(id);
        }
    }
}
