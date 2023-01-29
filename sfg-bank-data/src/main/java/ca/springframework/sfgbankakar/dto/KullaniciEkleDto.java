package ca.springframework.sfgbankakar.dto;

public class KullaniciEkleDto {

    private String kimlikNo;
    private String adSoyadi;
    private String email;
    private String telefonNo;
    private String adres;
    private String sifre;
    private Long cinsiyet;
    private boolean ekleControl;

    public boolean isEkleControl() {
        return ekleControl;
    }

    public void setEkleControl(boolean ekleControl) {
        this.ekleControl = ekleControl;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getAdSoyadi() {
        return adSoyadi;
    }

    public void setAdSoyadi(String adSoyadi) {
        this.adSoyadi = adSoyadi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefonNo() {
        return telefonNo;
    }

    public void setTelefonNo(String telefonNo) {
        this.telefonNo = telefonNo;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Long getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(Long cinsiyet) {
        this.cinsiyet = cinsiyet;
    }
}
