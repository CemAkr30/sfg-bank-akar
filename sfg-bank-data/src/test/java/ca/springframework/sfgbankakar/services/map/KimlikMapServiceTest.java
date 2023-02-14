package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.mapper.AdresMapper;
import ca.springframework.sfgbankakar.mapper.AdresMapperImpl;
import ca.springframework.sfgbankakar.model.Kimlik;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class KimlikMapServiceTest {

    KimlikMapService kimlikMapService;

    AdresMapper adresMapper;

    @BeforeEach
    void setUp() {
        adresMapper = new AdresMapperImpl();
        kimlikMapService = new KimlikMapService(new AdresMapService(adresMapper));
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