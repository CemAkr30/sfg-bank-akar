package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.dto.AuthenticatioRequest;
import ca.springframework.sfgbankakar.exception.AuthenticationException;
import ca.springframework.sfgbankakar.services.jwtService.AuthenticationService;
import ca.springframework.sfgbankakar.dto.AuthenticationResponse;
import ca.springframework.sfgbankakar.dto.RegisterRequest;
import ca.springframework.sfgbankakar.validators.AuthenticationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class AuthenticationController {


//    @Autowired
//    private KullaniciGirisService kullaniciGirisService;

    @Autowired
    private final AuthenticationService authenticationServiceervice;


    //Bu metod ve antasyon sayesinde kendi yaptığımız hata validasyonlarını kullanmamızı sağlamaktadır.
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new AuthenticationValidator());
    }

    public AuthenticationController(AuthenticationService authenticationServiceervice) {
        this.authenticationServiceervice = authenticationServiceervice;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@Valid @RequestBody KimlikCommand registerRequest,
                                                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
          // System.out.println(bindingResult.getAllErrors().get(0).getDefaultMessage());
           throw new AuthenticationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return ResponseEntity.ok(authenticationServiceervice.register(registerRequest)); //kayıt aşaması
    }

   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticatioRequest request){
        return ResponseEntity.ok(authenticationServiceervice.authenticate(request));
    }

    //    @Autowired
//    private EmailService emailService;


//    @RequestMapping("/auth")
//    @PostMapping
//    public AuthLoginDto authLogin(@RequestBody KullaniciGiris kullaniciGiris){
//        return  kullaniciGirisService.loginControl(kullaniciGiris);
//    }
//
//    @PostMapping("/loginOnay/{kimlikNo}")
//    public String sendMail(@PathVariable("kimlikNo") String kimlikNo){
//       Set<Kimlik> kimlikSet = kimlikService.findAll();
//       Set<Adres> adresSet=null;
//        for ( Kimlik kimlik : kimlikSet) {
//            adresSet = kimlik.getAdresSet();
//            for(Adres adres : adresSet) {
//                emailService.send(adres.getEmail(), "springtestmailtest@gmail.com",
//                        "AkarBank tarafından doğrulama Kodu gönderilecektir.");
//            }
//        }
//        return "Başarılı Mail";
//    }
}
