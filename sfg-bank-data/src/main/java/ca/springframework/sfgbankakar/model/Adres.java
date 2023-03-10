package ca.springframework.sfgbankakar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ADRES" ,schema = "BANK")
public class Adres  extends BaseEntity {

    @Column(name = "BEYAN_ADRES")
    private String beyanAdres;

    @Email
    @Column(name = "EMAIL")
    private String email;

    @JsonIgnore
    @ManyToOne
    private Kimlik kimlik;
}
