package ca.springframework.sfgbankakar.mapper;

import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.model.Adres;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AdresMapper {

    AdresMapper INSTANCE = Mappers.getMapper(AdresMapper.class);

    AdresDTO adresToAdresDTO(Adres adres);

    Adres adresDTOtoAdres(AdresDTO adresDTO);
}
