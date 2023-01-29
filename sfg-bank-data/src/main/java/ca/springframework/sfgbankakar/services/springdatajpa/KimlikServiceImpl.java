package ca.springframework.sfgbankakar.services.springdatajpa;


import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa") // KimlikService türeyen 2 class biri KimlikServiceImpl diğeri KimlikMapService Qualifer vermek yerine injection yaparken
//profile olanlara göre injection gerçekleştir. MapService ile fake jpa yapmıştık  mantığı anlamak için ancak şimdi jpa kullanarak
//hibernate tarafına mapleri göndererek crud işlemler yapılacaktır.
public class KimlikServiceImpl implements KimlikService {

    private final KimlikRepository kimlikRepository;


    public KimlikServiceImpl(KimlikRepository kimlikRepository) {
        this.kimlikRepository = kimlikRepository;
    }


    @Override
    public Kimlik findByAdiSoyadi(String adiSoyadi) {
        return null;
    }

    @Override
    public Set<Kimlik> findAll() {
        Set<Kimlik> kimlikSet = new HashSet<>();
        kimlikRepository.findAll().forEach(kimlikSet::add);
        return kimlikSet;
    }

    @Override
    public Kimlik findById(Long aLong) {
        return kimlikRepository.findById(aLong).orElse(null);
    }

    @Override
    public Kimlik save(Kimlik object) {
        return kimlikRepository.save(object);
    }

    @Override
    public void delete(Kimlik object) {
        kimlikRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        kimlikRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        kimlikRepository.deleteAll();
    }
}