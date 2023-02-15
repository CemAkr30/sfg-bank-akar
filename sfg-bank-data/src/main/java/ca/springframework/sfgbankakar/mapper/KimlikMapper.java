package ca.springframework.sfgbankakar.mapper;

import ca.springframework.sfgbankakar.dto.KimlikDTO;
import ca.springframework.sfgbankakar.model.Kimlik;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface KimlikMapper {

    KimlikMapper INSTANCE = Mappers.getMapper(KimlikMapper.class);

    KimlikDTO kimlikToKimlikDTO(Kimlik kimlik);

    Kimlik kimlikDTOtoKimlik(KimlikDTO kimlikDTO);

}
