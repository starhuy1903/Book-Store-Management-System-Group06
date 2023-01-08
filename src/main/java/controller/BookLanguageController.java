/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import entity.BookLanguage;
import dao.*;
import java.util.*;
/**
 *
 * @author DELL
 */
public class BookLanguageController {
    public List<BookLanguage> getAll() {
        BookLanguageDAO cd = new BookLanguageDAO();
        return cd.getAll();
    }
    
    public void create(BookLanguage bl){
        BookLanguageDAO cd = new BookLanguageDAO();
        cd.create(bl);
    }

    public void edit(BookLanguage bl) {
        BookLanguageDAO cd = new BookLanguageDAO();
        BookLanguage oldBL = cd.getById(bl.getLanguage_id());
        cd.update(bl);
    }

}
