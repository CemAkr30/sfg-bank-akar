package ca.springframework.sfgbankakar.dto;

import ca.springframework.sfgbankakar.enums.Role;
import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciGirisDTO {

    private Long id;
    private String password;
    private String  username;
    private Kimlik kimlik;
    private Role role;

}
