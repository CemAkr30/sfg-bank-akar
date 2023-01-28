//package ca.springframework.sfgbankakar.services.mailSender;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class MailSenderService {
//
//    private final JavaMailSender javaMailSender;
//
//    @Autowired
//    public MailSenderService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    protected void sendMail(String toEMail, String subject, String body ){
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setFrom(toEMail);
//        simpleMailMessage.setSubject(subject);
//        simpleMailMessage.setText(body);
//
//        javaMailSender.send(simpleMailMessage);
//
//        System.out.println("Mail Send Loading...");
//    }
//
//}
