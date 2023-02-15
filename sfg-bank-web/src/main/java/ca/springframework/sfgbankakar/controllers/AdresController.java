package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.mailSender.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping(AdresController.BASE_URL)
@CrossOrigin("*")
public class AdresController {

    public static final String BASE_URL = "api/adres";


    private final EmailService emailService;
    private final AdresService adresService;

    public AdresController(EmailService emailService, AdresService adresService) {
        this.emailService = emailService;
        this.adresService = adresService;
    }


    @PostMapping("/save")
    public AdresDTO save(@RequestBody AdresDTO adresDTO){
        return adresService.createNewAdres(adresDTO);
    }

//    @PostMapping("/mailSend")
//    public void mailSend(){
//        int i = 0;
//        String kod = "";
//            Random random = new Random();
//            kod = String.valueOf(random.nextInt());
//         emailService.send("tmrcksry8@gmail.com",
//                 "springtestmailtest@gmail.com",
//                 "Banka hesabınıza giriş yapabilmek için doğrulama kodunu lütfen," +
//                         "giriniz : 2307 -> Not: Seray Tomurcuk hanıma özel" );
//    }

}
