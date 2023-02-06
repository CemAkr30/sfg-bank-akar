package ca.springframework.sfgbankakar.commands.commandConverters;

import ca.springframework.sfgbankakar.commands.IletisimCommand;
import ca.springframework.sfgbankakar.model.Iletisim;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static ca.springframework.sfgbankakar.defaults.BaseDefault.checkNull;

@Component
public class IletisimCommandToIletisim implements Converter<IletisimCommand, Iletisim> {

    @Override
    public Iletisim convert(IletisimCommand source) {
        if(checkNull(source)){
            return null;
        }
        Iletisim iletisim = new Iletisim();

        iletisim.setKimlik(source.getKimlik());
        iletisim.setEvTelefonNo(source.getEvTelefonNo());
        iletisim.setTelefonNo(source.getTelefonNo());

        return iletisim;
    }
}
