package controller;
import dao.BookDAO;
import java.util.*;
import dao.PublisherDAO;
import entity.Publisher;
import enumeration.PublisherStatus;

public class PublisherController {
    public List<Publisher> getAll(){
        PublisherDAO da = new PublisherDAO();
        return da.getAll();
    }
    
    public void edit(Publisher publisher) {
        PublisherDAO pd = new PublisherDAO();
        Publisher oldPublisher = pd.getById(publisher.getId());
        if((oldPublisher.getStatus() == PublisherStatus.valueOf("ENABLED"))&&(publisher.getStatus() == PublisherStatus.valueOf("DISABLED"))){
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
}
