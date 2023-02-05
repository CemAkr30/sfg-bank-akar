package ca.springframework.sfgbankakar.commands.commandConverters;

import ca.springframework.sfgbankakar.commands.KullaniciGirisCommand;
import ca.springframework.sfgbankakar.defaults.BaseDefault;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class KullaniciGirisCommandToKullaniciGiris implements Converter<KullaniciGirisCommand, KullaniciGiris> {


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public KullaniciGiris convert(KullaniciGirisCommand source) {
        if(BaseDefault.checkNull(source)){
            return null;
        }
        KullaniciGiris kullaniciGiris = new KullaniciGiris();
        kullaniciGiris.setKimlik(source.getKimlik());
        kullaniciGiris.setPassword(passwordEncoder.encode(source.getPassword()));
        kullaniciGiris.setUsername(source.getUsername());
        kullaniciGiris.setRole(source.getRole());

        return kullaniciGiris;
    }
}
