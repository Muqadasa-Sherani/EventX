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
public abstract class User implements Discount {
    private  String name;
    private  String surname;
    private  String phoneNumber;
    private  String e_mail;
    private  String gender;
    private  String type;
    private String password ;
    public User() {
   
}
 
    public User(String name, String surname, String phoneNumber, String e_mail, String password ,String gender, String type) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.e_mail = e_mail;
        this.gender = gender;
        this.type = type;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getGender() {
        return gender;
    }

    public String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }

}
