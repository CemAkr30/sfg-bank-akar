package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.AuthLoginDto;
import ca.springframework.sfgbankakar.model.KullaniciGiris;

import java.util.Optional;

public interface KullaniciGirisService{
    AuthLoginDto loginControl(KullaniciGiris kullaniciGiris);

    KullaniciGiris loginOnay(String kimlikNo);

    Optional<KullaniciGiris> findByUsername(String username);
}
