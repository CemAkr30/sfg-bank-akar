package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.mapper.AdresMapper;
import ca.springframework.sfgbankakar.mapper.AdresMapperImpl;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class AdresMapServiceTest {


    @InjectMocks
    AdresMapper adresMapper;

    @Mock
    AdresMapService adresMapService;

    @Mock
    AbstractMapService abstractMapService;
    @BeforeEach
    void setUp() {
        adresMapper = new AdresMapperImpl();
        adresMapService = new AdresMapService(adresMapper);
    }
    @Test
    void findAll() throws Exception {
        List<Adres> adresList = Arrays.asList(Adres.builder()
                .kimlik(new Kimlik())
                .email("test@gmail.com")
                .beyanAdres("test adres").build(),Adres.builder()
                .kimlik(new Kimlik())
                .email("test@gmail.com")
                .beyanAdres("test adres").build()
        );

        when(abstractMapService.findAll()).thenReturn(new HashSet<>(adresList));

        Set<Adres> adresSetWhen = abstractMapService.findAll();

        assertEquals(adresSetWhen.size(),adresList.size());
    }
    @Test
    void save() throws Exception {
        Adres adres = Adres.builder()
                .kimlik(new Kimlik())
                .email("test@gmail.com")
                .beyanAdres("test adres").build();

      //  when(abstractMapService.save(1L,any(Adres.class))).thenReturn(adres);

        Adres savedAdres = adresMapService.save(adres);

        assertEquals(savedAdres.getBeyanAdres(),adres.getBeyanAdres());
        assertEquals(savedAdres.getEmail(),adres.getEmail());
    }
    @Test
    void createNewAdres() throws Exception {

        //given
        AdresDTO adresDTO = new AdresDTO();
        adresDTO.setBeyanAdres("Test Beyan Adres");
        adresDTO.setEmail("ejeje@gmail.com");
        adresDTO.setKimlik(new Kimlik());

        Adres adres = new Adres();
        adres.setBeyanAdres(adresDTO.getBeyanAdres());
        adres.setEmail(adresDTO.getEmail());
        adres.setKimlik(adresDTO.getKimlik());
        adres.setId(1L);

    //    when(adresMapService.createNewAdres(any(AdresDTO.class))).thenReturn(adresDTO);

        //when
        AdresDTO savedDto = adresMapService.createNewAdres(adresDTO);

        //then
        assertEquals(savedDto.getEmail(), adresDTO.getEmail());
    }
}