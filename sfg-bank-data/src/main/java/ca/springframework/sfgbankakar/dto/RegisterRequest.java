package ca.springframework.sfgbankakar.dto;

import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.Kimlik;
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
public class RegisterRequest {

    private Kimlik kimlik;
    private Set<Adres> adresSet = new HashSet<>();
    private Set<Iletisim> iletisimSet = new HashSet<>();
    private KullaniciGiris kullaniciGiris;
}
