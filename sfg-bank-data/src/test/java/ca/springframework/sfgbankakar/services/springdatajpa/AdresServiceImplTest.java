package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.mapper.AdresMapper;
import ca.springframework.sfgbankakar.mapper.AdresMapperImpl;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.AdresRepository;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.map.AdresMapService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class AdresServiceImplTest {


    AdresMapper adresMapper = AdresMapper.INSTANCE;

    @Mock
    AdresRepository adresRepository;

    AdresService adresService;

    @BeforeEach
    public void setUp() throws Exception {
      //  MockitoAnnotations.initMocks(this);
        adresService = new AdresServiceImpl(adresMapper,adresRepository);
    }

    @Test
    void findAll() {
        List<Adres> adresList = adresListReturn();

        when(adresRepository.findAll()).thenReturn(adresList);

        Set<Adres> adresSetReturn = adresService.findAll();

        assertEquals(adresSetReturn.size(),adresList.size());
    }

    @Test
    void save() {
        Adres adres = adresReturn();
        adres.setId(1L);

        when(adresRepository.save(any(Adres.class))).thenReturn(adres);


        Adres savedAdres = adresService.save(adres);

        assertEquals(savedAdres.getBeyanAdres(),adres.getBeyanAdres());
    }
    @Test
    void createNewAdres() {
       AdresDTO adresDTO =  new AdresDTO();
       Adres adres = adresReturn();
       adresDTO.setBeyanAdres(adres.getBeyanAdres());
       adresDTO.setEmail(adres.getEmail());
       adresDTO.setKimlik(adres.getKimlik());

       when(adresRepository.save(any(Adres.class))).thenReturn(adres);

       AdresDTO adresDTOreturn = adresService.createNewAdres(adresDTO);

       assertEquals(adresDTOreturn.getBeyanAdres(),adres.getBeyanAdres());
    }

    private List<Adres> adresListReturn(){
      return  Arrays.asList(Adres.builder()
                .kimlik(new Kimlik())
                .email("test@gmail.com")
                .beyanAdres("test adres").build(),Adres.builder()
                .kimlik(new Kimlik())
                .email("test@gmail.com")
                .beyanAdres("test adres").build()
        );
    }
    private Adres adresReturn(){
      return  Adres.builder()
                .kimlik(new Kimlik())
                .email("test@gmail.com")
                .beyanAdres("test adres").build();
    }
}