package controller;
import java.util.*;
import dao.PublisherDAO;
import entity.Publisher;

public class PublisherController {
    public List<Publisher> getAll(){
        PublisherDAO da = new PublisherDAO();
        return da.getAll();
    }
}
