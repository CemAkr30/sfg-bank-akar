package ca.springframework.sfgbankakar.model;



import ca.springframework.sfgbankakar.crypt.AES;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KULLANICI_GIRIS" ,schema = "BANK")
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
        String pass="";
        if(sifre!=null){
           try {
               AES aes = new AES();
               aes.init();
               String encryptedMessage = aes.encrypt(sifre);
               sifre =encryptedMessage;
           }catch (Exception ignored){
                throw new RuntimeException(ignored.getMessage());
           }
        }
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
