package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.services.Crudservice;

import java.util.Set;


public class AdresMapService extends AbstractMapService<Adres,Long> implements Crudservice<Adres,Long> {

    //Jpa taklit ettik, crudService methodları override ettirdi abstractmapservice de dbmiz gibi

    @Override
    public Set<Adres> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
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
}
