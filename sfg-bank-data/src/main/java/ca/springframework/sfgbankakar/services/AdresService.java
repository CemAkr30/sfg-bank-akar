package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.model.Adres;



public interface AdresService extends Crudservice<Adres,Long> {

    Adres findByBeyanAdres(String beyanAdres);


//    Adres findById(Long id);
//    Adres save(Adres adres);
//    Set<Adres> findAll();
}
