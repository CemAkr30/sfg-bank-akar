package ca.springframework.sfgbankakar.mapper;


import ca.springframework.sfgbankakar.dto.KullaniciGirisDTO;
import ca.springframework.sfgbankakar.enums.Role;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KullaniciGirisMapperTest {

    private  static  final  String USERNAME = "CA";
    private  static  final  String PASSWORD = "CA";

    @Test
    void kullaniciGirisToKullaniciGirisDTO() throws Exception {

        KullaniciGiris kullaniciGiris = KullaniciGiris.builder()
                .username(USERNAME)
                .password(PASSWORD)
                .role(Role.USER)
                .kimlik(new Kimlik())
                .build();

        KullaniciGirisDTO kullaniciGirisDTO =
                KullaniciGirisMapper.INSTANCE.kullaniciGirisToKullaniciGirisDTO(kullaniciGiris);

        assertEquals(USERNAME,kullaniciGirisDTO.getUsername());
        assertEquals(PASSWORD,kullaniciGirisDTO.getPassword());
    }
}