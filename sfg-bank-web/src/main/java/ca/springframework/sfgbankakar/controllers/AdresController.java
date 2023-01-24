package ca.springframework.sfgbankakar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdresController {
    @GetMapping({"/adres","/adres.html"})
    public String listAdress(){
        return "ADRES SAYFASINA HOŞGELDİN";
    }
}
