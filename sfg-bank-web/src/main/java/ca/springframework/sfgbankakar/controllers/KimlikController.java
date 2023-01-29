package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.KimlikService;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class KimlikController {

    private final KimlikService kimlikService;

    public KimlikController(KimlikService kimlikService) {
        this.kimlikService = kimlikService;
    }


    @GetMapping({"/kimlik","/kimlik.html"})
    public String kimlikPage(){
        return "KIMLIK SAYFASINA HOŞGELDİN";
    }

    @GetMapping({"/kimlikList","/kimlikList.html"})
    public  Set<Kimlik> listKimliks(){
        return  kimlikService.findAll();
    }


    @PostMapping({"/kullanciEkle","/kullanciEkle.html"})
    public String kullaniciEkle(@RequestBody Kimlik kimlik){
        return "";
    }

}
