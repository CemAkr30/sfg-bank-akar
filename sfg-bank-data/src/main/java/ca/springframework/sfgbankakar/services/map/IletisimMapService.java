package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.services.Crudservice;
import ca.springframework.sfgbankakar.services.IletisimService;

import java.util.Set;

//implements Crudservice<Iletisim,Long>
public class IletisimMapService  extends AbstractMapService<Iletisim,Long> implements IletisimService {


    @Override
    public Set<Iletisim> findAll() {
        return super.findAll();
    }

//    @Override
//    public Iletisim print() {
//        return new Iletisim();
//    }

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

    @Override
    public Iletisim findByTelefonNo(String telefonNo) {
        return null;
    }
}
