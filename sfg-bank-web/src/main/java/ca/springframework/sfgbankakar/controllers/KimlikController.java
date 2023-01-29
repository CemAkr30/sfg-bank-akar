package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.dto.KullaniciEkleDto;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.KimlikService;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/giris")
@CrossOrigin("*") // Not: farklı localhost request atmak için
public class KimlikController {

    private final KimlikService kimlikService;

    public KimlikController(KimlikService kimlikService) {
        this.kimlikService = kimlikService;
    }

    @GetMapping("/kimlik")
    public  Set<Kimlik> kimlikList(){
        return  kimlikService.findAll();
    }

    @PostMapping("/kimlik")
    public KullaniciEkleDto kullaniciEkle(@RequestBody Kimlik kimlik){
        return kimlikService.kullaniciEkle(kimlik);
    }

}
