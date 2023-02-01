package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.services.KimlikService;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import ca.springframework.sfgbankakar.services.mailSender.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("BANKSISTEM/login")
@RestController
public class KullaniciGirisController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private KimlikService kimlikService;


    @Autowired
    private KullaniciGirisService kullaniciGirisService;


    @RequestMapping("/auth")
    @PostMapping
    public boolean authLogin(@RequestBody KullaniciGiris kullaniciGiris){
      Boolean aBoolean =   kullaniciGirisService.loginControl(kullaniciGiris);
      return aBoolean.booleanValue();
    }

    @GetMapping({"/giris","/giris.html"})
    public String sendMail(){
       Set<Kimlik> kimlikSet = kimlikService.findAll();
       Set<Adres> adresSet=null;
        for ( Kimlik kimlik : kimlikSet) {
            adresSet = kimlik.getAdresSet();
            for(Adres adres : adresSet) {
                emailService.send(adres.getEmail(), "springtestmailtest@gmail.com",
                        "İlk mail entegrasyonumuz <3 Author:CA");
            }
        }
        return "Başarılı Mail";
    }

}
