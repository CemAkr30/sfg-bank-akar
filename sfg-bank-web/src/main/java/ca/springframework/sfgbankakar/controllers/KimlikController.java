package ca.springframework.sfgbankakar.controllers;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.KimlikService;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(KimlikController.BASE_URL)
@Slf4j
@CrossOrigin("*") // Not: farklı localhost request atmak için
public class KimlikController {


    public static final String BASE_URL = "/api/giris";

    private final KimlikService kimlikService;

    public KimlikController(KimlikService kimlikService) {
        this.kimlikService = kimlikService;
    }

    @GetMapping("/kimlik")
    public  Set<Kimlik> kimlikList(){
        log.info("Kimlik listesi getiriliyor");
        return  kimlikService.findAll();
    }

}
