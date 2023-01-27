package ca.springframework.sfgbankakar.model;


import ca.springframework.sfgbankakar.enums.Cinsiyet;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "KIMLIK" ,schema = "BANK")
public class Kimlik extends BaseEntity {

    public Kimlik() {
    }

    @Column(name = "ADI_SOYADI",nullable = true)
    private String adiSoyadi;

    @Column(name = "CINSIYET")
    private Cinsiyet cinsiyet;

    @Column(name = "KIMLIK_NO",length = 11,nullable = true)
    private String kimlikNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<Adres> adresSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<Iletisim> iletisimSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<KullaniciGiris> kullaniciGirisSet = new HashSet<>();


    public void addIletisimSet(Iletisim iletisim){
        this.iletisimSet.add(iletisim);
    }

    public void addAdresSet(Adres adres){
        this.adresSet.add(adres);
    }


    public String getAdiSoyadi() {
        return adiSoyadi;
    }

    public void setAdiSoyadi(String adiSoyadi) {
        this.adiSoyadi = adiSoyadi;
    }

    public Cinsiyet getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Cinsiyet cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public Set<Adres> getAdresSet() {
        return adresSet;
    }

    public void setAdresSet(Set<Adres> adresSet) {
        this.adresSet = adresSet;
    }

    public Set<Iletisim> getIletisimSet() {
        return iletisimSet;
    }

    public void setIletisimSet(Set<Iletisim> iletisimSet) {
        this.iletisimSet = iletisimSet;
    }
}
