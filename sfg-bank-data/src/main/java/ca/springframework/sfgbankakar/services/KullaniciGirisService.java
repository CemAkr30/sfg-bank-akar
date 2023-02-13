package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.model.KullaniciGiris;

import java.util.Optional;

public interface KullaniciGirisService{

    KullaniciGiris loginOnay(String kimlikNo);

    Optional<KullaniciGiris> findByUsername(String username);
}
