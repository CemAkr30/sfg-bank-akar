package ca.springframework.sfgbankakar.commands.commandConverters;

import ca.springframework.sfgbankakar.commands.AdresCommand;
import ca.springframework.sfgbankakar.commands.IletisimCommand;
import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.defaults.BaseDefault;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.services.jwtService.JwtService;
import com.sun.istack.Nullable;
import lombok.Synchronized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class KimlikCommandToKimlik implements Converter<KimlikCommand, Kimlik> {

    private String jwtToken;

    private final AdresCommandToAdres adresCommandToAdres;
    private final IletisimCommandToIletisim iletisimCommandToIletisim;
    private final KullaniciGirisCommandToKullaniciGiris kullaniciGirisCommand;

    @Autowired
    private JwtService jwtService;


    public KimlikCommandToKimlik(AdresCommandToAdres adresCommandToAdres, IletisimCommandToIletisim iletisimCommandToIletisim, KullaniciGirisCommandToKullaniciGiris kullaniciGirisCommand) {
        this.adresCommandToAdres = adresCommandToAdres;
        this.iletisimCommandToIletisim = iletisimCommandToIletisim;
        this.kullaniciGirisCommand = kullaniciGirisCommand;
    }

    @Synchronized
    @Nullable
    @Override
    public Kimlik convert(KimlikCommand source) {
        if(BaseDefault.checkNull(source)){
            return null;
        }

        final Kimlik kimlik = new Kimlik();
        kimlik.setId(source.getId());
        kimlik.setKimlikNo(source.getKimlikNo());
        kimlik.setCinsiyet(source.getCinsiyet());
        kimlik.setAdiSoyadi(source.getAdiSoyadi());

        source.getKullaniciGirisCommand().setKimlik(kimlik);
        kimlik.setKullaniciGiris(kullaniciGirisCommand.convert(source.getKullaniciGirisCommand()));

        if(BaseDefault.isNotEmptySet(source.getAdresCommandSet())){
            for(AdresCommand adresCommandRec : source.getAdresCommandSet()) {
                adresCommandRec.setKimlik(kimlik);
                kimlik.addAdresSet(adresCommandToAdres.convert(adresCommandRec));
            }
        }

        if(BaseDefault.isNotEmptySet(source.getIletisimCommandSet())){
            for(IletisimCommand iletisimCommandRec : source.getIletisimCommandSet()) {
                iletisimCommandRec.setKimlik(kimlik);
                kimlik.addIletisimSet(iletisimCommandToIletisim.convert(iletisimCommandRec));
            }
        }

        //token key üretelim
       setJwtToken(jwtToken(kimlik.getKullaniciGiris()));

        return kimlik;
    }

    public String jwtToken(KullaniciGiris user){
      return  jwtService.generateToken(user);
    }

    public void setJwtToken(String token){
        this.jwtToken = token;
    }

    public String getJwtToken(){
        return this.jwtToken;
    }
}
