package controller;

import dao.AuthorDAO;
import dao.BookDAO;
import entity.Author;
import enumeration.AuthorStatus;
import java.util.*;

public class AuthorController {

    public List<Author> getAll() {
        AuthorDAO ad = new AuthorDAO();
        return ad.getAll();
    }
    
    public void create(Author author){
        AuthorDAO ad = new AuthorDAO();
        ad.create(author);
    }

    public void edit(Author author) {
        AuthorDAO ad = new AuthorDAO();
        Author oldAuthor = ad.getById(author.getId());
        if ((oldAuthor.getStatus() == AuthorStatus.valueOf("ENABLED")) && (author.getStatus() == AuthorStatus.valueOf("DISABLED"))) {
            BookDAO bd = new BookDAO();
            bd.updateStatusWithCondition("DISABLED", "author_id", Long.toString(author.getId()));
        }
       ad.update(author);
    }

    public void editMany(List<Author> list) {
        for (Author cat : list) {
            edit(cat);
        }
    }

    public boolean delete(Long id) {
        AuthorDAO ad = new AuthorDAO();
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
