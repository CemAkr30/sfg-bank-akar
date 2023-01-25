package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
