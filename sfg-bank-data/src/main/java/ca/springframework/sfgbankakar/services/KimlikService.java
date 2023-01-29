package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.KullaniciEkleDto;
import ca.springframework.sfgbankakar.model.Kimlik;

public interface KimlikService extends Crudservice<Kimlik,Long> {


    KullaniciEkleDto kullaniciEkle(KullaniciEkleDto kullaniciEkleDto);

    //TODO  base interface bunları kullandığı için gerek yok artık
//    Kimlik findById(Long id);
//    Kimlik save(Kimlik kimlik);
//    Set<Kimlik> findAll();

}
