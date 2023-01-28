package ca.springframework.sfgbankakar.converters;



import ca.springframework.sfgbankakar.enums.Cinsiyet;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class CinsiyetConverter implements AttributeConverter<Cinsiyet, Long>{

    @Override
    public Long convertToDatabaseColumn(Cinsiyet type) {
        return type.getId();
    }

    @Override
    public Cinsiyet convertToEntityAttribute(Long databaseValue) {
        return Cinsiyet.getCinsiyet(databaseValue);
    }
}