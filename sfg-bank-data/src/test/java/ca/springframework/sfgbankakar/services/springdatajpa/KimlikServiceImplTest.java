package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class KimlikServiceImplTest {

    KimlikServiceImpl kimlikService;

    @Mock // taklit objesi oluşturuyoruz
    KimlikRepository kimlikRepository;

    @Mock
    KullaniciGirisRepository kullaniciGirisRepository;


    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.openMocks(this); // ExtendWith  veya Runner kullanılmıyorsa, bu MockitoAnnotations kullanılmalı

        kimlikService = new KimlikServiceImpl(kimlikRepository,kullaniciGirisRepository); // taklit objesini enjekte ettik
    }

    @Test
    void findAll() throws Exception {
        Kimlik kimlik = new Kimlik();
        List<Kimlik> kimlikData =  new ArrayList<>();
        kimlikData.add(kimlik);

        when(kimlikRepository.findAll()).thenReturn( kimlikData); // findAll ne gelirse kimlikdata dön
        //Mock nesnemize davranış belirtmek için ilk yöntemimiz when().then()
        //eq() -- anyString()

        Set<Kimlik> kimlikSet = kimlikService.findAll();

        assertEquals(kimlikSet.size(),1);
        verify(kimlikRepository, Mockito.times(1)).findAll(); // Mockito.verify()  bu methodların çağırıp çağırmadığını belirtir
                                                                                    //Mockito.times() kaç kez çağrılmış
    }
}