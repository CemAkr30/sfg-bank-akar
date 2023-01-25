package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.services.Crudservice;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Set;


//Crudservice<Kimlik,Long>
@Component
public class KimlikMapService extends AbstractMapService<Kimlik,Long> implements KimlikService {


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
        return super.save(object.getId(),object);
    }

    @Override
    public Kimlik findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Kimlik findByAdiSoyadi(String adiSoyadi) {
        return null;
    }
}
