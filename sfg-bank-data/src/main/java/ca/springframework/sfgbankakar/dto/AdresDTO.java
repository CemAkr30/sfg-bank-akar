package ca.springframework.sfgbankakar.dto;


import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdresDTO  extends BaseDTO {

    private String beyanAdres;
    private String email;
    private Kimlik kimlik;
}
