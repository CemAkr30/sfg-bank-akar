package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.services.Crudservice;


public interface AdresService extends Crudservice<Adres,Long> {

    Adres findByBeyanAdres(String beyanAdres);


//    Adres findById(Long id);
//    Adres save(Adres adres);
//    Set<Adres> findAll();
}
