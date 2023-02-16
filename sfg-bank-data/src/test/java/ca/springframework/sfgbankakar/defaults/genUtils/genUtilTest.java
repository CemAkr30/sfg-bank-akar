package ca.springframework.sfgbankakar.defaults.genUtils;

import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.enums.Cinsiyet;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class genUtilTest {

    @Test
    void pojoToDto(){
        Adres adres = Adres.builder()
                .email("testmail")
                .kimlik(Kimlik.builder()
                        .kimlikNo("1241245151")
                        .adiSoyadi("CA")
                        .cinsiyet(Cinsiyet.ERKEK)
                        .build())
                .beyanAdres("deneme").build();

        AdresDTO adresDTO = new AdresDTO();
        adresDTO.setBeyanAdres(adres.getBeyanAdres());

     AdresDTO genUtilDto = new GenUtilMap<AdresDTO,Adres>().pojoToDto(new AdresDTO(),adres);

     assertEquals(genUtilDto.getBeyanAdres(),adres.getBeyanAdres());
    }


    @Test
    void dtoToPojo() {
        Adres adres = Adres.builder()
                .email("testmail")
                .kimlik(Kimlik.builder()
                        .kimlikNo("1241245151")
                        .adiSoyadi("CA")
                        .cinsiyet(Cinsiyet.ERKEK)
                        .build())
                .beyanAdres("deneme").build();

     AdresDTO genUtilDto = new GenUtilMap<AdresDTO,Adres>().pojoToDto(new AdresDTO(),adres);

     Adres pojoUtil = new GenUtilMap<AdresDTO,Adres>().dtoToPojo(genUtilDto,new Adres());

     assertEquals(pojoUtil.getBeyanAdres(),genUtilDto.getBeyanAdres());
    }



    @Test
    void pojoToListDto(){
        Adres adres = Adres.builder()
                .email("testmail")
                .kimlik(Kimlik.builder()
                        .kimlikNo("1241245151")
                        .adiSoyadi("CA")
                        .cinsiyet(Cinsiyet.ERKEK)
                        .build())
                .beyanAdres("deneme").build();

        Adres adres2 = Adres.builder()
                .email("testmail2222")
                .kimlik(Kimlik.builder()
                        .kimlikNo("5555555")
                        .adiSoyadi("CA2")
                        .cinsiyet(Cinsiyet.ERKEK)
                        .build())
                .beyanAdres("deneme22222").build();

        List<AdresDTO> genUtilDto = new GenUtilMap<AdresDTO,Adres>().pojoToListDto(new AdresDTO(),Arrays.asList(adres,adres2));


        assertEquals(genUtilDto.get(0).getBeyanAdres(),adres.getBeyanAdres());
    }



    @Test
    void dtoToListPojo(){
        Adres adres = Adres.builder()
                .email("testmail")
                .kimlik(Kimlik.builder()
                        .kimlikNo("1241245151")
                        .adiSoyadi("CA")
                        .cinsiyet(Cinsiyet.ERKEK)
                        .build())
                .beyanAdres("deneme").build();

        Adres adres2 = Adres.builder()
                .email("testmail2222")
                .kimlik(Kimlik.builder()
                        .kimlikNo("5555555")
                        .adiSoyadi("CA2")
                        .cinsiyet(Cinsiyet.ERKEK)
                        .build())
                .beyanAdres("deneme22222").build();

        List<AdresDTO> genUtilDtoList = new GenUtilMap<AdresDTO,Adres>().pojoToListDto(new AdresDTO(),Arrays.asList(adres,adres2));


        List<Adres> adresList = new GenUtilMap<AdresDTO,Adres>().dtoToListPojo(genUtilDtoList,new Adres());

        assertEquals(genUtilDtoList.get(0).getBeyanAdres(),adres.getBeyanAdres());
    }
}