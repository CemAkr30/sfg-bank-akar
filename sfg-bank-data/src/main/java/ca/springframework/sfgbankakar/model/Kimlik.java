package ca.springframework.sfgbankakar.model;


import ca.springframework.sfgbankakar.enums.Cinsiyet;
import lombok.Builder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "KIMLIK" ,schema = "BANK")
public class Kimlik extends BaseEntity {

    @Builder
    public Kimlik(String adiSoyadi, Cinsiyet cinsiyet, String kimlikNo, Set<Adres> adresSet, Set<Iletisim> iletisimSet,KullaniciGiris kullaniciGiris) {
        this.adiSoyadi = adiSoyadi;
        this.cinsiyet = cinsiyet;
        this.kimlikNo = kimlikNo;
        if(adresSet!=null) {
            this.adresSet = adresSet;
        }
        if(iletisimSet!=null) {
            this.iletisimSet = iletisimSet;
        }
        if(kullaniciGiris!=null){
            this.kullaniciGiris = kullaniciGiris;
        }
    }

    public Kimlik() {
    }

    @Column(name = "ADI_SOYADI",nullable = true)
    private String adiSoyadi;

    @Enumerated(EnumType.STRING)
    @Column(name = "CINSIYET")
    private Cinsiyet cinsiyet;

    @Column(name = "KIMLIK_NO",length = 11,nullable = true)
    private String kimlikNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<Adres> adresSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<Iletisim> iletisimSet = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private KullaniciGiris kullaniciGiris;


    public void addIletisimSet(Iletisim iletisim){
        this.iletisimSet.add(iletisim);
    }

    public void addAdresSet(Adres adres){
        this.adresSet.add(adres);
    }


    public KullaniciGiris getKullaniciGiris() {
        return kullaniciGiris;
    }

    public void setKullaniciGiris(KullaniciGiris kullaniciGiris) {
        this.kullaniciGiris = kullaniciGiris;
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

    public Set<Iletisim> getIletisimSet() {
        return iletisimSet;
    }

    public void setAdresSet(Set<Adres> adresSet) {
        this.adresSet = adresSet;
    }

    public void setIletisimSet(Set<Iletisim> iletisimSet) {
        this.iletisimSet = iletisimSet;
    }
}
