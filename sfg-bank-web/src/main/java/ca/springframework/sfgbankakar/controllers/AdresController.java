package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.services.AdresService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AdresController.BASE_URL)
@CrossOrigin("*")
public class AdresController {

    public static final String BASE_URL = "api/adres";

    private final AdresService adresService;

    public AdresController(AdresService adresService) {
        this.adresService = adresService;
    }


    @PostMapping("/save")
    public AdresDTO save(@RequestBody AdresDTO adresDTO){
        return adresService.createNewAdres(adresDTO);
    }
}
