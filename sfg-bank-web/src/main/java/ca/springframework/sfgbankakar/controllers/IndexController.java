package ca.springframework.sfgbankakar.controllers;

import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.commands.commandConverters.KimlikCommandToKimlik;
import ca.springframework.sfgbankakar.model.Kimlik;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//RestController method tarafında ki string değeri bile dönerken @controller dönmüyor thymeleaf göre -> resources/templates directory dönüyor
@RequestMapping("/v1")
@RestController
public class IndexController {

    private final KimlikCommandToKimlik kimlikCommandToKimlik;

    public IndexController(KimlikCommandToKimlik kimlikCommandToKimlik) {
        this.kimlikCommandToKimlik = kimlikCommandToKimlik;
    }

    //Mapping de belirtilen türlere göre request atılır
    @GetMapping("/")
    public ResponseEntity<Kimlik> index(@RequestBody KimlikCommand kimlikCommand){
        return ResponseEntity.ok(kimlikCommandToKimlik.convert(kimlikCommand));
//        return "WELCOME INDEX PAGE";
    }
}
