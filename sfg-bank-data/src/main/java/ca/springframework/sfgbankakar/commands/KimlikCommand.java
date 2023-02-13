package ca.springframework.sfgbankakar.commands;

import ca.springframework.sfgbankakar.enums.Cinsiyet;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KimlikCommand extends CommandBase {

    private String adiSoyadi;
    private Cinsiyet cinsiyet;
    private String kimlikNo;
    private Set<AdresCommand> adresCommandSet = new HashSet<>();
    private Set<IletisimCommand> iletisimCommandSet = new HashSet<>();
    private KullaniciGirisCommand kullaniciGirisCommand;

    /**
      DTO ve Command class'lar aslında birbirlerine benzer ama ufak bir farkları var
     Command class da manuel converter yaparken, DTO class'lar da kullanılan @MapStruct annatoion
     sayesinde otomatik neseneleri dto mapler. 
    **/

}
