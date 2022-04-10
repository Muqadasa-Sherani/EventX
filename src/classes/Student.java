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
public class Student extends User implements Discount  {
     private String studentId;
    
    
     public Student(String name, String surname, String phoneNumber, String e_mail,String password, String gender, String type, String studentId ) {
        super(name, surname, phoneNumber, e_mail, password, gender,type);
        this.studentId= studentId;
    }

    public String getStudentId() {
        return studentId;
    }


    @Override
    public double calculateDiscount(double price) {
       //if you are a student,you can benefit from %50 discount.
       price=(price*50)/100;
       return price;
       
    } 
}
 