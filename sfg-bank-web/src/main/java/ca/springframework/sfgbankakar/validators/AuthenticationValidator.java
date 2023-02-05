package ca.springframework.sfgbankakar.validators;


import ca.springframework.sfgbankakar.commands.KimlikCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class AuthenticationValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return KimlikCommand.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        KimlikCommand kimlikCommand = (KimlikCommand) target;
        if(kimlikCommand.getKimlikNo().length() != 11){
            errors.reject("E00001", "Tc Kimlik numarası 11 hane dışında olamaz!!!");
        }
    }
}
