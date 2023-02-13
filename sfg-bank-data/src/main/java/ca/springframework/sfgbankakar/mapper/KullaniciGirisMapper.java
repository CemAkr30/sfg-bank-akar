package ca.springframework.sfgbankakar.mapper;

import ca.springframework.sfgbankakar.dto.KullaniciGirisDTO;
import ca.springframework.sfgbankakar.model.KullaniciGiris;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface KullaniciGirisMapper {

    KullaniciGirisMapper INSTANCE = Mappers.getMapper(KullaniciGirisMapper.class);

    KullaniciGirisDTO kullaniciGirisToKullaniciGirisDTO(KullaniciGiris kullaniciGiris);

    KullaniciGiris kullaniciGirisDTOtoKullaniciGiris (KullaniciGirisDTO kullaniciGirisDTO);
}
