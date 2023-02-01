package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.model.KullaniciGiris;

public interface KullaniciGirisService{
    Boolean loginControl(KullaniciGiris kullaniciGiris);
    KullaniciGiris loginOnay(String kimlikNo);
}
