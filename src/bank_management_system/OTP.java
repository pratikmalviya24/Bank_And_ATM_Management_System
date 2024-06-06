package bank_management_system;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class OTP {

    public OTP(String bodyMessage,String userEmailId) throws Exception{
 
         Properties prop = new Properties();
//        prop.put("mail.smtp.auth", true);
//        prop.put("mail.smtp.starttls.enable", "true");
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
//        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("monsterplayer924@gmail.com", "gbbk zyyr jioe fhqm");
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("monsterplayer924@gmail.com"));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(userEmailId));
        message.setSubject("INDIAN BANK");
        message.setText(bodyMessage);
        Transport.send(message);
    }
    
    public static void main(String[] args) throws Exception{
       new OTP("Hello Mitul", "varunpujara05@gmail.com");
    }
}
