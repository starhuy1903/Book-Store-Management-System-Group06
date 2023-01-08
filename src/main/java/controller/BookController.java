package controller;

import dao.BookDAO;
import entity.Book;
import enumeration.AuthorStatus;
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
    
    public void create(Book book){
        BookDAO bd = new BookDAO();
        bd.create(book);
    }

    public boolean delete(Long id) {
        BookDAO ad = new BookDAO();
        BookDAO bd = new BookDAO();
        int count = bd.countByColumn("author_id", Long.toString(id));
        if(count > 0) return false;
        
        ad.delete(id);
        return true;
    }
    
    public List<Long> deleteMany(List<Long> list) {
        List<Long> fail = new ArrayList();
        for (Long id : list) {
            if(!delete(id)) fail.add(id);
        }
        return fail;
    }
}
