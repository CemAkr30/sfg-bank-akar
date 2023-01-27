package ca.springframework.sfgbankakar.enums;

import java.io.Serializable;

public enum Cinsiyet implements Serializable {
    ERKEK(1L, "ERKEK"),
    KADIN(2L, "KADIN");

    private final Long id;
    private final String adi;

    Cinsiyet(Long id, String adi) {
        this.id = id;
        this.adi = adi;
    }

    public static Cinsiyet getCinsiyet(Long id) {
        if (id == null) {
            return null;
        }
        for (Cinsiyet type: Cinsiyet.values()) {
            if (id == type.getId()) {
                return type;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }
    public String getAdi() {
        return adi;
    }

}