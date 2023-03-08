package ca.springframework.sfgbankakar.enums;

import java.io.Serializable;

public enum JoinType {


    INNER_JOIN(1,"INNER JOIN"),

    LEFT_JOIN(2,"LEFT JOIN"),

    RIGHT_JOIN(3,"RIGHT JOIN");


    JoinType(Serializable id, String adi) {
        this.id = id;
        this.adi = adi;
    }

    private final Serializable id;
    private final String adi;

    public Serializable getId() {
        return id;
    }

    public String getAdi() {
        return adi;
    }
}
