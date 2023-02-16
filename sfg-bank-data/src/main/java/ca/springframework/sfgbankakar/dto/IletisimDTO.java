package ca.springframework.sfgbankakar.dto;


import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class IletisimDTO extends BaseDTO {


    private String telefonNo;
    private String evTelefonNo;
    private Kimlik kimlik;
}
