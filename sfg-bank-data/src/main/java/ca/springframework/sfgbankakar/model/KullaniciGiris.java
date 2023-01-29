package ca.springframework.sfgbankakar.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KULLANICI_GIRIS")
public class KullaniciGiris  extends  BaseEntity {

    public KullaniciGiris() {
    }

    @Column(name = "SIFRE")
    private String sifre;

    @Column(name = "KULLANICI_KODU")
    private String  kullaniciKodu;

    @ManyToOne
    private Kimlik kimlik;


    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getKullaniciKodu() {
        return kullaniciKodu;
    }

    public void setKullaniciKodu(String kullaniciKodu) {
        this.kullaniciKodu = kullaniciKodu;
    }

    public Kimlik getKimlik() {
        return kimlik;
    }

    public void setKimlik(Kimlik kimlik) {
        this.kimlik = kimlik;
    }
}
