package ca.springframework.sfgbankakar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ILETISIM" ,schema = "BANK")
public class Iletisim extends BaseEntity {


    public Iletisim() {
    }

    @Column(name = "TELEFON_NO")
    private String telefonNo;

    @Column(name = "EV_TELEFON_NO")
    private String evTelefonNo;

    @ManyToOne
    private Kimlik kimlik;


    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getEvTelefonNo() {
        return evTelefonNo;
    }

    public void setEvTelefonNo(String evTelefonNo) {
        this.evTelefonNo = evTelefonNo;
    }

    public Kimlik getKimlik() {
        return kimlik;
    }

    public void setKimlik(Kimlik kimlik) {
        this.kimlik = kimlik;
    }
}
