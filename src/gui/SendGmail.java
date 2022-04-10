package gui;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
/**
 *
 * @author Muqadasa Sherani
 */
public class SendGmail {
    public static void sendMail(String recepient) throws Exception{
        System.out.println("Preparing to send email.");
        Properties properties = new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail = "eventx.event@gmail.com";
        String password = "eventx123";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            //implement abstract method of the class Authenticator.
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(myAccountEmail, password);
            }
        });
        
        Message message = prepareMessage(session, myAccountEmail, recepient);
        
        Transport.send(message);
        System.out.println("Message sent successfully");
        
    }
    
    //message method. The text inside the email is edited in this method.
    private static Message prepareMessage(Session session, String myAccountEmail, String recepient) throws MessagingException{
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Welcome to EventX!");
            message.setText("You are a new member of our Community \n EventX");
            String htmlCode="<h1> WELCOME TO THE EVENTX </h1> <br/> <h2><b>Thank You For Joining us <3 </b></h2>";
            message.setContent(htmlCode, "text/html");
            return message;
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(SendGmail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return null;
    }
}



