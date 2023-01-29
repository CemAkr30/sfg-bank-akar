package ca.springframework.sfgbankakar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KimlikTest {

    Kimlik kimlik;

    @BeforeEach
    public void setUp(){
        kimlik = new Kimlik();
    }

    @Test
    void getKimlikNo() {
        kimlik.setKimlikNo("14928514821");
        assertEquals("14928514821",kimlik.getKimlikNo());
    }
}