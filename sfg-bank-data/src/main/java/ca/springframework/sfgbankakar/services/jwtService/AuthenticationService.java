package ca.springframework.sfgbankakar.services.jwtService;

import ca.springframework.sfgbankakar.dto.AuthenticatioRequest;
import ca.springframework.sfgbankakar.dto.AuthenticationResponse;
import ca.springframework.sfgbankakar.dto.RegisterRequest;
import ca.springframework.sfgbankakar.enums.Role;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Iletisim;
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
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        Kimlik kimlik = new Kimlik();
        Adres adres = null;
        Iletisim iletisim = null;
        KullaniciGiris user = KullaniciGiris.builder()
                .username(request.getKullaniciGiris().getUsername())
                .password(passwordEncoder.encode(request.getKullaniciGiris().getPassword()))
                .role(Role.USER)
                .build();
        for (Adres recAdres : request.getAdresSet()){
            adres = new Adres();
            adres.setEmail(recAdres.getEmail());
            adres.setBeyanAdres(recAdres.getBeyanAdres());
            adres.setKimlik(kimlik);
            kimlik.addAdresSet(adres);
        }
        for (Iletisim recIletisim : request.getIletisimSet()){
            iletisim = new Iletisim();
            iletisim.setTelefonNo(recIletisim.getTelefonNo());
            iletisim.setEvTelefonNo(recIletisim.getEvTelefonNo());
            iletisim.setKimlik(kimlik);
            kimlik.addIletisimSet(iletisim);
        }
        user.setKimlik(kimlik);

        kimlik.setKullaniciGiris(user);
        kimlik.setKimlikNo(request.getKimlik().getKimlikNo());
        kimlik.setAdiSoyadi(request.getKimlik().getAdiSoyadi());
        kimlik.setCinsiyet(request.getKimlik().getCinsiyet());

        kimlikRepository.save(kimlik);

        String jwtToken = jwtService.generateToken(user);
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
