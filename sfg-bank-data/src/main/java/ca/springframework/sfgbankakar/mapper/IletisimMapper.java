package ca.springframework.sfgbankakar.mapper;

import ca.springframework.sfgbankakar.dto.IletisimDTO;
import ca.springframework.sfgbankakar.model.Iletisim;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IletisimMapper {

    IletisimMapper INSTANCE = Mappers.getMapper(IletisimMapper.class);

    IletisimDTO iletisimToIletisimDTO(Iletisim iletisim);
    Iletisim iletisimDTOtoIletisim(IletisimDTO iletisimDTO);
}
