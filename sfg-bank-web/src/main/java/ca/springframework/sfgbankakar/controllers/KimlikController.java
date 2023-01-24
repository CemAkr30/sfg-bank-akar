package ca.springframework.sfgbankakar.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KimlikController {

    @GetMapping({"/kimlik","/kimlik.html"})
    public String listKimliks(){
        return "KIMLIK SAYFASINA HOŞGELDİN";
    }

}
