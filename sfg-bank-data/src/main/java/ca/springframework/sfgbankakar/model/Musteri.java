package ca.springframework.sfgbankakar.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "MUSTERI" ,schema = "BANK")
public class Musteri  extends  BaseEntity {

    @JsonIgnore
    @OneToOne
    private Kimlik kimlik;

    @Column(name = "BAKIYE")
    private Double bakiye;

    @Column(name = "IBAN_NO")
    private String ibanNo;

    @Column(name = "HESAP_NO")
    private String hesapNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gonderenMusteri")
    private Set<TransferLog> gonderenMusteriLogSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gonderilenMusteri")
    private Set<TransferLog> gonderilenMusteriLogSet = new HashSet<>();


    public void gonderilenMusteriLogSet(TransferLog transferLog){
        this.gonderilenMusteriLogSet.add(transferLog);
    }

    public void gonderenMusteriLogSet(TransferLog transferLog){
        this.gonderenMusteriLogSet.add(transferLog);
    }

}
