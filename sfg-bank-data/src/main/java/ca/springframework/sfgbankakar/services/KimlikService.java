package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.KimlikDTO;
import ca.springframework.sfgbankakar.model.Kimlik;

import java.util.List;

public interface KimlikService extends Crudservice<Kimlik,Long> {

    Kimlik findByAdiSoyadi(String adiSoyadi);
    Kimlik findByKimlikNo(String kimlikNo);

    List<KimlikDTO> getAllKimlik();

    KimlikDTO getKimlikById(Long id);

    KimlikDTO createNewKimlik(KimlikDTO customerDTO);

    KimlikDTO patchKimlik(Long id, KimlikDTO customerDTO);

    void deleteKimlikById(Long id);

}
