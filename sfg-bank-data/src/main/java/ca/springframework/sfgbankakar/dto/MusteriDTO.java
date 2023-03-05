package ca.springframework.sfgbankakar.dto;


import ca.springframework.sfgbankakar.model.Kimlik;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusteriDTO  extends  BaseDTO {

    private Kimlik kimlik;
    private Double bakiye;
    private String ibanNo;
    private String hesapNo;

}
