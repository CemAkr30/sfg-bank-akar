package ca.springframework.sfgbankakar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "ADRES" ,schema = "BANK")
public class Adres  extends BaseEntity {

    public Adres() {
    }

    @Column(name = "BEYAN_ADRES")
    private String beyanAdres;

    @Column(name = "EMAIL")
    private String email;

    @ManyToOne
    private Kimlik kimlik;


    public String getBeyanAdres() {
        return beyanAdres;
    }

    public void setBeyanAdres(String beyanAdres) {
        this.beyanAdres = beyanAdres;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Kimlik getKimlik() {
        return kimlik;
    }

    public void setKimlik(Kimlik kimlik) {
        this.kimlik = kimlik;
    }
}
