package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.model.Kimlik;

public interface KimlikService extends Crudservice<Kimlik,Long> {

    Kimlik findByAdiSoyadi(String adiSoyadi);
    Kimlik findByKimlikNo(String kimlikNo);

    //TODO  base interface bunları kullandığı için gerek yok artık
//    Kimlik findById(Long id);
//    Kimlik save(Kimlik kimlik);
//    Set<Kimlik> findAll();

}
