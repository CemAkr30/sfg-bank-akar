package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.services.mailSender.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KullaniciGirisController {

    @Autowired
    private EmailService emailService;

    @GetMapping({"/giris","/giris.html"})
    public String sendMail(){
        emailService.send("byrankon18@gmail.com","springtestmailtest@gmail.com",
                "502145");
        return "Başarılı Mail";
    }

}
