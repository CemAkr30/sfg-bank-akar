package ca.springframework.sfgbankakar.model;


import ca.springframework.sfgbankakar.enums.Cinsiyet;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "ADI_SOYADI")
    private String adiSoyadi;

    @Enumerated(EnumType.STRING)
    @Column(name = "CINSIYET")
    private Cinsiyet cinsiyet;

    @NotNull
    @Column(name = "KIMLIK_NO")
    private String kimlikNo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<Adres> adresSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Set<Iletisim> iletisimSet = new HashSet<>();

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private KullaniciGiris kullaniciGiris;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "kimlik",fetch = FetchType.EAGER)
    private Musteri musteri;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gonderenMusteri",fetch = FetchType.EAGER)
    private Set<TransferLog> gonderenMusteriSet = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gonderilenMusteri",fetch = FetchType.EAGER)
    private Set<TransferLog> gonderilenMusteriSet = new HashSet<>();



    public void addGonderenMusteriSet(TransferLog transferLog){
        this.gonderenMusteriSet.add(transferLog);
    }

    public void addGonderilenMusteriSet(TransferLog transferLog){
        this.gonderilenMusteriSet.add(transferLog);
    }

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

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
}
