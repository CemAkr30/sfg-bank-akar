package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.services.Crudservice;

import java.util.Set;

public class IletisimMapService  extends AbstractMapService<Iletisim,Long> implements Crudservice<Iletisim,Long> {


    @Override
    public Set<Iletisim> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Iletisim object) {
        super.delete(object);
    }

    @Override
    public Iletisim save(Iletisim object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Iletisim findById(Long id) {
        return super.findById(id);
    }
}
