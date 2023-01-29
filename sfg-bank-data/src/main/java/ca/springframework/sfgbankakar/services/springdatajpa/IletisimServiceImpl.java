package ca.springframework.sfgbankakar.services.springdatajpa;


import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.repositories.IletisimRepository;
import ca.springframework.sfgbankakar.services.IletisimService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class IletisimServiceImpl implements IletisimService {

    private final IletisimRepository iletisimRepository;

    public IletisimServiceImpl(IletisimRepository iletisimRepository) {
        this.iletisimRepository = iletisimRepository;
    }

    @Override
    public Set<Iletisim> findAll() {
        Set<Iletisim> iletisimSet = new HashSet<>();
        iletisimRepository.findAll().forEach(iletisimSet::add);
        return iletisimSet;
    }

    @Override
    public Iletisim findById(Long aLong) {
        return iletisimRepository.findById(aLong).orElse(null);
    }

    @Override
    public Iletisim save(Iletisim object) {
        return iletisimRepository.save(object);
    }

    @Override
    public void delete(Iletisim object) {
        iletisimRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        iletisimRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        iletisimRepository.deleteAll();
    }
}
