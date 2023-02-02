package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.dto.AuthLoginDto;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import ca.springframework.sfgbankakar.services.KimlikService;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("springdatajpa")
public class KullaniciGirisServiceImpl implements KullaniciGirisService {

    private final KullaniciGirisRepository kullaniciGirisRepository;
    private final KimlikService kimlikService;

    public KullaniciGirisServiceImpl(KullaniciGirisRepository kullaniciGirisRepository, KimlikService kimlikService) {
        this.kullaniciGirisRepository = kullaniciGirisRepository;
        this.kimlikService = kimlikService;
    }

    @Override
    public AuthLoginDto loginControl(KullaniciGiris kullaniciGiris) {
        AuthLoginDto authLoginDto = new AuthLoginDto();
        KullaniciGiris login = kullaniciGirisRepository.findByKullaniciKoduAndSifre(kullaniciGiris.getKullaniciKodu(), kullaniciGiris.getSifre());
        Kimlik kimlik = kimlikService.findByKimlikNo(login.getKullaniciKodu());
        authLoginDto.setLoginOnay(false);

        for (Adres adres : kimlik.getAdresSet()) {
            authLoginDto.setEmail(adres.getEmail());
            break;
        }

        if (login != null) {
            authLoginDto.setLoginOnay(true);
        }
        return authLoginDto;
    }

    @Override
    public KullaniciGiris loginOnay(String kimlikNo) {
        return null;
    }
}
