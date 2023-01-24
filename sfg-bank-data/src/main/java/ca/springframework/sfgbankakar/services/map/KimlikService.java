package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.Crudservice;

public interface KimlikService extends Crudservice<Kimlik,Long> {

    Kimlik findByAdiSoyadi(String adiSoyadi);


    //TODO  base interface bunları kullandığı için gerek yok artık
//    Kimlik findById(Long id);
//    Kimlik save(Kimlik kimlik);
//    Set<Kimlik> findAll();

}
