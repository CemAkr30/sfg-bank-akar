package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.model.Adres;

import java.util.List;


public interface AdresService extends Crudservice<Adres,Long> {

    List<AdresDTO> getAllAdres();

    AdresDTO getAdresById(Long id);

    AdresDTO createNewAdres(AdresDTO customerDTO);

    AdresDTO patchAdres(Long id, AdresDTO customerDTO);

    void deleteAdresById(Long id);

}
