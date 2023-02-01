package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.dto.KullaniciEkleDto;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


//Crudservice<Kimlik,Long>
@Service
@Profile({"default", "map"})
public class KimlikMapService extends AbstractMapService<Kimlik,Long> implements KimlikService {

    private final AdresService adresService;

    public KimlikMapService(AdresService adresService) {
        this.adresService = adresService;
    }

    // CrudService taklit ederek memberları oluşturduk super. abstarctmap gidecek
    @Override
    public Set<Kimlik> findAll() {
        return super.findAll();
    }

//    @Override
//    public Kimlik print() {
//        Kimlik kimlik = super.print();
//        System.out.println(kimlik.getAdiSoyadi() + "," + kimlik.getKimlikNo());
//        return kimlik;
//    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    public void delete(Kimlik object) {
            super.delete(object);
    }

    @Override
    public Kimlik save(Kimlik object) {
        if (object != null) {
            if (object.getAdresSet() != null) {
                object.getAdresSet().forEach(adres -> {
                            if(adres.getId()==null){
                                Adres savedAdres = adresService.save(adres);
                                adres.setId(savedAdres.getId());
                                // adresService.save(adres); adres zaten memory de tutulduğundan getNextId id setlediği zaman otomatik objede change oluyor
                                //heap memory objeler
                            }
                        }
                );
            }
        }
        return super.save(object.getId(),object);
    }

    @Override
    public Kimlik findById(Long id) {
        return super.findById(id);
    }

    @Override
    public KullaniciEkleDto kullaniciEkle(Kimlik kimlik) {
        return null;
    }

    @Override
    public Kimlik findByAdiSoyadi(String adiSoyadi) {
        return null;
    }

}
