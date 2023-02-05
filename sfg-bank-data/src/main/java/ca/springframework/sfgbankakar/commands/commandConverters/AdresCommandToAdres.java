package ca.springframework.sfgbankakar.commands.commandConverters;

import ca.springframework.sfgbankakar.commands.AdresCommand;
import ca.springframework.sfgbankakar.defaults.BaseDefault;
import ca.springframework.sfgbankakar.model.Adres;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdresCommandToAdres implements Converter<AdresCommand, Adres>  {

    @Override
    public Adres convert(AdresCommand source) {
        if(BaseDefault.checkNull(source)){
            return null;
        }
        Adres adres = new Adres();
        adres.setId(source.getId());
        adres.setBeyanAdres(source.getBeyanAdres());
        adres.setEmail(source.getEmail());
        adres.setKimlik(source.getKimlik());

        return adres;
    }
}
