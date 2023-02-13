package ca.springframework.sfgbankakar.services.springdatajpa;


import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import ca.springframework.sfgbankakar.services.KimlikService;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Optional;


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
    public KullaniciGiris loginOnay(String kimlikNo) {
        return null;
    }

    @Override
    public Optional<KullaniciGiris> findByUsername(String username) {
        return kullaniciGirisRepository.findByUsername(username);
    }
}
