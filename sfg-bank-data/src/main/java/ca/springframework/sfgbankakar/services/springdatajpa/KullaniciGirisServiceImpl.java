package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.crypt.AES;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class KullaniciGirisServiceImpl implements KullaniciGirisService {

    private final KullaniciGirisRepository kullaniciGirisRepository;

    public KullaniciGirisServiceImpl(KullaniciGirisRepository kullaniciGirisRepository) {
        this.kullaniciGirisRepository = kullaniciGirisRepository;
    }

    @Override
    public Boolean loginControl(KullaniciGiris kullaniciGiris) {
        Boolean aBoolean = Boolean.FALSE;
        KullaniciGiris login = kullaniciGirisRepository.findByKullaniciKoduAndSifre(kullaniciGiris.getKullaniciKodu(),kullaniciGiris.getSifre());
        if(login!=null){
            aBoolean = Boolean.TRUE;
        }
     return aBoolean;
    }

    @Override
    public KullaniciGiris loginOnay(String kimlikNo) {
        return null;
    }
}
