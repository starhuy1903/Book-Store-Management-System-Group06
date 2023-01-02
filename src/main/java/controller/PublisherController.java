package controller;

import dao.BookDAO;
import java.util.*;
import dao.PublisherDAO;
import entity.Publisher;
import enumeration.PublisherStatus;

public class PublisherController {

    public List<Publisher> getAll() {
        PublisherDAO pd = new PublisherDAO();
        return pd.getAll();
    }
    
    public void create(Publisher publisher){
        PublisherDAO pd = new PublisherDAO();
        pd.create(publisher);
    }

    public void edit(Publisher publisher) {
        PublisherDAO pd = new PublisherDAO();
        Publisher oldPublisher = pd.getById(publisher.getId());
        if ((oldPublisher.getStatus() == PublisherStatus.valueOf("ENABLED")) && (publisher.getStatus() == PublisherStatus.valueOf("DISABLED"))) {
            BookDAO bd = new BookDAO();
            bd.updateStatusWithCondition("DISABLED", "publisher_id", Long.toString(publisher.getId()));
        }
        pd.update(publisher);
    }

    public void editMany(List<Publisher> list) {
        for (Publisher pub : list) {
            edit(pub);
        }
    }

    public boolean delete(Long id) {
        PublisherDAO pd = new PublisherDAO();
        BookDAO bd = new BookDAO();
        int count = bd.countByColumn("publisher_id", Long.toString(id));
        if(count > 0) return false;
        
        pd.delete(id);
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
