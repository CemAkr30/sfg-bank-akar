package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.AdresService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KimlikMapServiceTest {

    KimlikMapService kimlikMapService;

    @BeforeEach
    void setUp() {
        kimlikMapService = new KimlikMapService(new AdresMapService());
        kimlikMapService.save(Kimlik.builder().adiSoyadi("CA").build());
    }

    @Test
    void findAll() {
        Set<Kimlik> kimlikSet = kimlikMapService.findAll();
        assertEquals(1,kimlikSet.size());
    }

    @Test
    void save() {
        Kimlik kimlik = Kimlik.builder().adiSoyadi("CaSave").build();
        Kimlik savedKimlik = kimlikMapService.save(kimlik);
    }
}