package ca.springframework.sfgbankakar.services.jwtService;

import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.commands.commandConverters.KimlikCommandToKimlik;
import ca.springframework.sfgbankakar.defaults.genUtils.GenUtilMap;
import ca.springframework.sfgbankakar.dto.AuthenticationRequestDTO;
import ca.springframework.sfgbankakar.dto.AuthenticationResponseDTO;
import ca.springframework.sfgbankakar.dto.KimlikDTO;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public AuthenticationResponseDTO register(KimlikDTO request) {

     Kimlik kimlik  = new GenUtilMap<KimlikDTO,Kimlik>().dtoToPojo(request,new Kimlik());

                    kimlik.getKullaniciGiris().setKimlik(kimlik);
                    kimlik.getAdresSet()
                            .forEach(adres -> adres.setKimlik(kimlik));
                    kimlik.getIletisimSet()
                            .forEach(iletisim -> iletisim.setKimlik(kimlik));

        String jwtToken = kimlikCommandToKimlik.getJwtToken();
        kimlikRepository.save(kimlik);

        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponseDTO authenticate(AuthenticationRequestDTO request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        KullaniciGiris user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        String jwtToken = jwtService.generateToken(user);
         return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }
}
