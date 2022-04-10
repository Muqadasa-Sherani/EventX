/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import java.util.Date;

/**
 *
 * @author mustafakapucu
 */
public class Event {
     private int eId;
     private String eTitle;
     private String eVenue;
     private Date eStart;
     private Date eHour;
     private String eDescription;
     private double ePrice;
     private byte[] eImage;
 

    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    
     public String geteTitle() {
        return eTitle;
    }

    public String geteVenue() {
        return eVenue;
    }

    public Date geteStart() {
        return eStart;
    }

    public Date geteHour() {
        return eHour;
    }

    public String geteDescription() {
        return eDescription;
    }

    public double getePrice() {
        return ePrice;
    }

    public byte[] geteImage() {
        return eImage;
    }
    
    

    public Event(int eId ,String eTitle, String eVenue, Date eStart, Date eHour, String eDescription, double ePrice, byte[] eImage) {
        this.eId= eId;
        this.eTitle = eTitle;
        this.eVenue = eVenue;
        this.eStart = eStart;
        this.eHour = eHour;
        this.eDescription = eDescription;
        this.ePrice = ePrice;
        this.eImage = eImage;
    }

    public void seteTitle(String eTitle) {
        this.eTitle = eTitle;
    }

    public void seteVenue(String eVenue) {
        this.eVenue = eVenue;
    }

    public void seteStart(Date eStart) {
        this.eStart = eStart;
    }

    public void seteHour(Date eHour) {
        this.eHour = eHour;
    }

    public void seteDescription(String eDescription) {
        this.eDescription = eDescription;
    }

    public void setePrice(double ePrice) {
        this.ePrice = ePrice;
    }
    
    
     
     
     

    
   
    
    
    
}
