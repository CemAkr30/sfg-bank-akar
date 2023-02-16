package ca.springframework.sfgbankakar.validators;


import ca.springframework.sfgbankakar.commands.KimlikCommand;
import ca.springframework.sfgbankakar.dto.KimlikDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AuthenticationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KimlikDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        KimlikDTO kimlikDTO = (KimlikDTO) target;
        if(kimlikDTO.getKimlikNo().length() != 11){
            errors.reject("E00001", "Tc Kimlik numarası 11 hane dışında olamaz!!!");
        }
    }
}
