package ca.springframework.sfgbankakar.services.jwtService;

import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.commands.commandConverters.KimlikCommandToKimlik;
import ca.springframework.sfgbankakar.dto.AuthenticatioRequest;
import ca.springframework.sfgbankakar.dto.AuthenticationResponse;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    @Autowired
    private final KullaniciGirisRepository userRepository;

    @Autowired
    private final KimlikRepository kimlikRepository;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    @Autowired
    private KimlikCommandToKimlik kimlikCommandToKimlik;

    public AuthenticationResponse register(KimlikCommand request) {

        Kimlik kimlik = kimlikCommandToKimlik.convert(request);
        String jwtToken = kimlikCommandToKimlik.getJwtToken();

        kimlikRepository.save(kimlik);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticatioRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        KullaniciGiris user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
         return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
