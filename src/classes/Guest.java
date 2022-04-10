/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
/**
 *
 * @author Efşan Albayrak
 */
public class Guest extends User implements Discount{
    public Guest(String name, String surname, String phoneNumber, String e_mail,String password ,String gender, String type) {
        super(name, surname, phoneNumber, e_mail,password, gender, type);
    }
    @Override
    public double calculateDiscount(double price) {
       //Anyone who uses our application can benefit from %5 discount.
       price=(price*95)/100;
       return price;
    } 
}

