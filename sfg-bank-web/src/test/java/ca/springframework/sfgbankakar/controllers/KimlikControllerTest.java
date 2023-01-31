package ca.springframework.sfgbankakar.controllers;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class KimlikControllerTest {

    @Mock
    KimlikService kimlikService;

    KimlikController kimlikController;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
        kimlikController = new KimlikController(kimlikService);
    }

    @Test
    public void testMockMVC() throws Exception{
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(kimlikController).build();// kimlikController build ederek taklit objesi oluşturur http katmanında
        mockMvc.perform(MockMvcRequestBuilders.get("/giris/kimlik"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void kimlikList() throws Exception {
        Set<Kimlik> kimlikSet = new HashSet<>();
        kimlikSet.add(new Kimlik());
        kimlikSet.add(new Kimlik());

        when(kimlikService.findAll()).thenReturn(kimlikSet);

        Set<Kimlik> kimlikSet1 = kimlikService.findAll();//findAll olunca -> yani yukarda ki gibi git bizim objemizi döndür böylece db den uzak ve hızlı test yapıyoruz

        assertEquals(kimlikSet1.size(),2);
        verify(kimlikService,times(1)).findAll();
    }
}