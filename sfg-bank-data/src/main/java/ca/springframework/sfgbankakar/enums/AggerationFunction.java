package ca.springframework.sfgbankakar.enums;

import java.io.Serializable;

public enum AggerationFunction {

    MAX(1,"MAX"),
    MIN(2,"MIN"),
    SUM(3,"SUM"),
    AVG(4,"AVG"),
    COUNT(5,"COUNT");


    private Serializable id;
    private String adi;

    AggerationFunction(Serializable id, String adi) {
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
