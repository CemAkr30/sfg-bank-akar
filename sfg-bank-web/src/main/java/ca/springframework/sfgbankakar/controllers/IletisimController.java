package ca.springframework.sfgbankakar.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IletisimController {


    @GetMapping({"/iletisim","/iletisim.html"})
    public String listIletisims(){
        return "ILETISIM SAYFASINA HOŞGELDİN";
    }

}
