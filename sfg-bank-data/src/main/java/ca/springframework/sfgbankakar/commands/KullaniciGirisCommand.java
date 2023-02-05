package ca.springframework.sfgbankakar.commands;

import ca.springframework.sfgbankakar.enums.Role;
import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KullaniciGirisCommand  extends CommandBase {

    private String password;
    private String  username;
    private Kimlik kimlik;
    private Role role;
}
