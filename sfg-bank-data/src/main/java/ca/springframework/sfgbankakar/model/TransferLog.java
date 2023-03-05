package ca.springframework.sfgbankakar.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MUSTERI" ,schema = "BANK")
public class TransferLog extends BaseEntity {


    /**
     *  transferLog.setGonderenMusteri(gonderenMusteriOptional.get());
     * //            transferLog.setGonderilenMusteri(gonderilenMusteriOptional.get());
     * //            transferLog.setGonderilenBakiye(bakiyeTransferDTO.getGonderilenBakiye());*/

    @JsonIgnore
    @ManyToOne
    private Musteri gonderenMusteri;

    @JsonIgnore
    @ManyToOne
    private Musteri gonderilenMusteri;

    private Double gonderilenBakiye;

}
