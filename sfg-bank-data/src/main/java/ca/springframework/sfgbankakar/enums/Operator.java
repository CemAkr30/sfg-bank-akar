package ca.springframework.sfgbankakar.enums;

import java.io.Serializable;

public enum Operator {


    /**
     *>
     * **/
    GRANDER_THAN(1,">"),

    /**
     *<
     * **/
    LESS_THAN(2,"<"),

    /**
     * ==
     * **/
    EQUAL(3,"="),

    /**
     * !=
     * **/
    NOT_EQUAL(4,"!="),

    /**
     *>=
     * */
    GRANDER_THAN_OR_EQUAL(5,">="),

    /**
     *<=
     *
     * */
    LESS_THAN_OR_EQUAL(6,"<="),
    ;

    private Serializable id;
    private String adi;


    Operator(Serializable id, String adi) {
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
