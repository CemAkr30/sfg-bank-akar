package ca.springframework.sfgbankakar.controllers;

import ca.springframework.sfgbankakar.dto.BakiyeTransferDTO;
import ca.springframework.sfgbankakar.dto.MusteriDTO;
import ca.springframework.sfgbankakar.services.MusteriService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(MusteriController.BASE_URL)
@CrossOrigin("*")
public class MusteriController {
    public static final String BASE_URL = "/api/musteri";

    private final MusteriService musteriService;

    public MusteriController(MusteriService musteriService) {
        this.musteriService = musteriService;
    }

    @GetMapping("/musterileriGetir")
    public List<MusteriDTO> musterileriGetir(){
        return musteriService.getAllMusteri();
    }

    @GetMapping("/musteriGetir/{id}")
    public ResponseEntity<MusteriDTO> musteriGetir(@PathVariable("id") Long id){
        return ResponseEntity.ok(musteriService.getMusteriById(id));
    }

    @PostMapping("/musteriKaydet/{kimlikId}")
    public ResponseEntity<String> createNewMusteri(@PathVariable("kimlikId") Long kimlikId,@RequestBody MusteriDTO musteriDTO){
        musteriService.createNewMusteri(kimlikId,musteriDTO);
        return ResponseEntity.ok("Müşteri kaydedildi");
    }

    @PatchMapping("/musteriUpdate/{kimlikId}")
    public ResponseEntity<String> musteriUpdate(@PathVariable("kimlikId") Long kimlikId,@RequestBody MusteriDTO musteriDTO){
        musteriService.patchMusteri(kimlikId,musteriDTO);
        return ResponseEntity.ok("Müşteri Güncellendi");
    }

    @PostMapping("/transferBakiye")
    public ResponseEntity<String> transferBakiye(@RequestBody BakiyeTransferDTO bakiyeTransferDTO){
        musteriService.transferBakiye(bakiyeTransferDTO);
        return ResponseEntity.ok("Bakiye transferi başarılı");
    }
}
