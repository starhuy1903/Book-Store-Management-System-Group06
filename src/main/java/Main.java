import controller.AccountController;
import view.AccountManagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Dai Hai
 */
public class Main {
    AccountManagement screen = new AccountManagement();
    
    public static void main(String args[]) {
//        screen = new AccountManagement();
        AccountController c = new AccountController();
        System.out.println(c.getAll().get(0));
  
    }    
}
