package controller;

import dao.BookDAO;
import dao.CategoryDAO;
import entity.Category;
import enumeration.CategoryStatus;
import java.util.*;

public class CategoryController {

    public List<Category> getAll() {
        CategoryDAO cd = new CategoryDAO();
        return cd.getAll();
    }
    
    public void create(Category category){
        CategoryDAO cd = new CategoryDAO();
        cd.create(category);
    }

    public void edit(Category category) {
        CategoryDAO cd = new CategoryDAO();
        Category oldCategory = cd.getById(category.getId());
        if ((oldCategory.getStatus() == CategoryStatus.valueOf("ENABLED")) && (category.getStatus() == CategoryStatus.valueOf("DISABLED"))) {
            BookDAO bd = new BookDAO();
            bd.updateStatusWithCondition("DISABLED", "publisher_id", Long.toString(category.getId()));
        }
        cd.update(category);
    }

    public void editMany(List<Category> list) {
        for (Category cat : list) {
            edit(cat);
        }
    }

    public boolean delete(Long id) {
        CategoryDAO cd = new CategoryDAO();
        BookDAO bd = new BookDAO();
        int count = bd.countByColumn("category_id", Long.toString(id));
        if(count > 0) return false;
        
        cd.delete(id);
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
