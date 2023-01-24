package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.Crudservice;

import java.util.Set;

public class KimlikMapService extends AbstractMapService<Kimlik,Long> implements Crudservice<Kimlik,Long> {


    // CrudService taklit ederek memberları oluşturduk super. abstarctmap gidecek
    @Override
    public Set<Kimlik> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Kimlik object) {
            super.delete(object);
    }

    @Override
    public Kimlik save(Kimlik object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Kimlik findById(Long id) {
        return super.findById(id);
    }
}
