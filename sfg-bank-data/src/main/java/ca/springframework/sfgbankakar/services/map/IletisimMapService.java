package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.dto.IletisimDTO;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.services.Crudservice;
import ca.springframework.sfgbankakar.services.IletisimService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

//implements Crudservice<Iletisim,Long>
@Service
@Profile({"default", "map"})
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
    public void deleteAll() {
        super.deleteAll();
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
    public List<IletisimDTO> getAllIletisim() {
        return null;
    }

    @Override
    public IletisimDTO getIletisimById(Long id) {
        return null;
    }

    @Override
    public IletisimDTO createNewIletisim(IletisimDTO customerDTO) {
        return null;
    }

    @Override
    public IletisimDTO patchIletisim(Long id, IletisimDTO customerDTO) {
        return null;
    }

    @Override
    public void deleteIletisimById(Long id) {

    }
}
