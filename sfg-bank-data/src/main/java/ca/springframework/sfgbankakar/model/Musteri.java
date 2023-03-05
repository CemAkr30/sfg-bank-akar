package ca.springframework.sfgbankakar.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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

}
