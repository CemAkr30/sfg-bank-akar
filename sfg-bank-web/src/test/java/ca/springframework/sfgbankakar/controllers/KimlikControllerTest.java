package ca.springframework.sfgbankakar.controllers;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // sayesinde  MockitoAnnotations.openMocks(this); kullanmaya gerek kalmadı
class KimlikControllerTest {

    @Mock
    KimlikService kimlikService;

    @InjectMocks
    KimlikController kimlikController; // InjectMocks sayesinde setUp tarafında injection yapmaya gerek kalmadı

    Set<Kimlik> kimlikSet;

    MockMvc mockMvc;

    /*WebTestClient -> manager sayesinde servislerimizi class gibi gösterip istek atabiliriz tipli
    * RestTemplateBuilder -> manager gibi ve test servisimizden istek attığımızda serverWebExchange manager
    * sayesinde gelen formDatayı alabiliriz*/

    @BeforeEach
    public void setUp() throws Exception{
        //MockitoAnnotations.openMocks(this);

        kimlikSet = new HashSet<>();
        kimlikSet.add(new Kimlik());
        kimlikSet.add(new Kimlik());

        mockMvc = MockMvcBuilders.standaloneSetup(kimlikController)
                .build();
    }

    @Test
    public void testMockMVC() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(kimlikController).build();// kimlikController build ederek taklit objesi oluşturur http katmanında
        mockMvc.perform(MockMvcRequestBuilders.get("/api/giris/kimlik"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void kimlikList() throws Exception {

        when(kimlikService.findAll()).thenReturn(kimlikSet);

        Set<Kimlik> kimlikSet1 = kimlikService.findAll();//findAll olunca -> yani yukarda ki gibi git bizim objemizi döndür böylece db den uzak ve hızlı test yapıyoruz

        assertEquals(kimlikSet1.size(),2);
        verify(kimlikService,times(1)).findAll();
    }
}