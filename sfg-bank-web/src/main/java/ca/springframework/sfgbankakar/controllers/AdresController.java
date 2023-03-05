package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.mailSender.EmailService;
import io.swagger.annotations.Api;
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

    //swagger-ui.html#/adres-controller (swagger) adresi olarak tag verebiliriz
   // @Api(value = "Adres kaydetme", notes = "Adres kaydetme) -> @RequestMapping(AdresController.BASE_URL) adres tag açıklama belirtir
    //@ApiOperation(value = "Adres kaydetme", notes = "Adres kaydetme") -> @PostMapping("/save") adres tag açıklama belirtir
    //Encaplsulation -> pojo tarafında da modellere @ApiModelProperty ekleyerek swagger açıklaması verebiliriz
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
