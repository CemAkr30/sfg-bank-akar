package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.AuthLoginDto;
import ca.springframework.sfgbankakar.model.KullaniciGiris;

public interface KullaniciGirisService{
    AuthLoginDto loginControl(KullaniciGiris kullaniciGiris);
    KullaniciGiris loginOnay(String kimlikNo);
}
