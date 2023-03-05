package ca.springframework.sfgbankakar.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BakiyeTransferDTO extends BaseDTO {

    private String gonderecekIbanNo;
    private String gonderilenIbanNo;
    private Double gonderilenBakiye;

}
