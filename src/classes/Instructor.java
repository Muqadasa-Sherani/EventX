/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


public class Instructor extends User implements Discount {
     

    public Instructor(String name, String surname, String phoneNumber, String e_mail,String password , String gender, String type) {
        super(name, surname, phoneNumber, e_mail,password, gender, type);
    }

    @Override
    public double calculateDiscount(double price) {
        //if you are a instructor,you can benefit from %10 discount.
       price=(price*90)/100;
       return price;
    }
}
