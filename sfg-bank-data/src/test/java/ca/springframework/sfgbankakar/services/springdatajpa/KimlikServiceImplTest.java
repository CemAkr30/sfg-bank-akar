package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class KimlikServiceImplTest {

    @InjectMocks //@Mockları injection eder setUp gerek kalmadı -> kimlikService = new KimlikServiceImpl(kimlikRepository);
    KimlikServiceImpl kimlikService;

    @Mock // taklit objesi oluşturuyoruz
    KimlikRepository kimlikRepository;

//    @BeforeEach
//    public void setUp() throws Exception{
//        MockitoAnnotations.openMocks(this); // ExtendWith  veya Runner kullanılmıyorsa, bu MockitoAnnotations kullanılmalı
//
//        kimlikService = new KimlikServiceImpl(kimlikRepository); // taklit objesini enjekte ettik
    // setUp gerek kalmadı çünkü InjectMock kullanıcaz
//    }

    @Test
    void findAll() throws Exception {
        Kimlik kimlik = new Kimlik();
        List<Kimlik> kimlikList =  new ArrayList<>();
        kimlikList.add(kimlik);

        //when -> eğer kimlikrepo.find all yaparsa bana kimlik data döndür
        when(kimlikRepository.findAll()).thenReturn(kimlikList); // findAll ne gelirse kimlikdata dön
        //Mock nesnemize davranış belirtmek için ilk yöntemimiz when().then()
        //eq() -- anyString()

        Set<Kimlik> kimlikSet = kimlikService.findAll();

        assertEquals(kimlikSet.size(),1);
        verify(kimlikRepository, Mockito.times(1)).findAll(); // Mockito.verify()  bu methodların çağırıp çağırmadığını belirtir
                                                                                    //Mockito.times() kaç kez çağrılmış
    }

    @Test
    void findByAdiSoyadi() {
        Kimlik returnKimlik = Kimlik.builder().adiSoyadi("CAKAR").build();
        when(kimlikRepository.findByAdiSoyadi(any())).thenReturn(returnKimlik);
        Kimlik cakar = kimlikService.findByAdiSoyadi("CAKAR");
        assertEquals("CAKAR",cakar.getAdiSoyadi());
    }
}