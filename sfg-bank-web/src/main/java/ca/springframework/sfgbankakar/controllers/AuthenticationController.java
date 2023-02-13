package ca.springframework.sfgbankakar.controllers;


import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.dto.AuthenticationRequestDTO;
import ca.springframework.sfgbankakar.dto.AuthenticationResponseDTO;
import ca.springframework.sfgbankakar.exception.AuthenticationException;
import ca.springframework.sfgbankakar.services.jwtService.AuthenticationService;
import ca.springframework.sfgbankakar.validators.AuthenticationValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController // @Controller yerine @RestController @ResponseBody'den de
// manager almaktadır. Bu sayaede ResponseEntity<> kullanmaya gerek kalmaz
@RequestMapping(AuthenticationController.BASE_URL)
@CrossOrigin("*")
public class AuthenticationController {

    public static final String BASE_URL = "/api/v1/auth";

    private final AuthenticationService authenticationServiceervice;


    public AuthenticationController(AuthenticationService authenticationServiceervice) {
        this.authenticationServiceervice = authenticationServiceervice;
    }

    //Bu metod ve antasyon sayesinde kendi yaptığımız hata validasyonlarını kullanmamızı sağlamaktadır.
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        webDataBinder.addValidators(new AuthenticationValidator());
    }

    //ResponseEntity<AuthenticationResponse>
    @PostMapping("/register")
    public AuthenticationResponseDTO register(@Valid @RequestBody KimlikCommand registerRequest,
                                                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
          // System.out.println(bindingResult.getAllErrors().get(0).getDefaultMessage());
           throw new AuthenticationException(bindingResult.getAllErrors().get(0).getDefaultMessage());
        }
        return authenticationServiceervice.register(registerRequest); //kayıt aşaması
    }

   // @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO request){
        return ResponseEntity.ok(authenticationServiceervice.authenticate(request));
    }

}
