package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.services.AdresService;
import ca.springframework.sfgbankakar.services.Crudservice;
import org.springframework.stereotype.Component;

import java.util.Set;

//implements Crudservice<Adres,Long> çıkartıyoruz üst sınıf veriyoruz
@Component
public class AdresMapService extends AbstractMapService<Adres,Long> implements AdresService {

    //Jpa taklit ettik, crudService methodları override ettirdi abstractmapservice de dbmiz gibi

    @Override
    public Set<Adres> findAll() {
        return super.findAll();
    }

//    @Override
//    public Adres print() {
//        return new Adres();
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
    public void delete(Adres object) {
        super.delete(object);
    }

    @Override
    public Adres save(Adres object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Adres findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Adres findByBeyanAdres(String beyanAdres) {
        return null;
    }
}
