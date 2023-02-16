package ca.springframework.sfgbankakar.dto;

import ca.springframework.sfgbankakar.enums.Cinsiyet;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KimlikDTO extends BaseDTO {

    private String adiSoyadi;
    private Cinsiyet cinsiyet;

    private String kimlikNo;

    private Set<Adres> adresSet = new HashSet<>();

    private Set<Iletisim> iletisimSet = new HashSet<>();

    private KullaniciGiris kullaniciGiris;

}
