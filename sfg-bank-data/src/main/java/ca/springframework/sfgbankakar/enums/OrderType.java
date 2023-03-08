package ca.springframework.sfgbankakar.enums;

import java.io.Serializable;

public enum OrderType {

    DESC(1,"DESC"),
    ASC(2,"ASC");


    private Serializable id;
    private String adi;

    OrderType(Serializable id, String adi) {
        this.id = id;
        this.adi = adi;
    }

    public Serializable getId() {
        return id;
    }

    public void setId(Serializable id) {
        this.id = id;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }
}
