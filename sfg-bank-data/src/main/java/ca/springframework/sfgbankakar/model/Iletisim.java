package ca.springframework.sfgbankakar.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ILETISIM" ,schema = "BANK")
public class Iletisim extends BaseEntity {

    @Column(name = "TELEFON_NO")
    private String telefonNo;

    @Column(name = "EV_TELEFON_NO")
    private String evTelefonNo;

    @ManyToOne
    private Kimlik kimlik;
}
