package ca.springframework.sfgbankakar.commands;


import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IletisimCommand  extends CommandBase {

    private String telefonNo;
    private String evTelefonNo;
    private Kimlik kimlik;
}
