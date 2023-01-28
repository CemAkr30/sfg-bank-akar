package ca.springframework.sfgbankakar.services.springdatajpa;


import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.repositories.AdresRepository;
import ca.springframework.sfgbankakar.services.AdresService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class AdresSDService implements AdresService {

   private final AdresRepository adresRepository;

    public AdresSDService(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    @Override
    public Set<Adres> findAll() {
        Set<Adres> adresSet = new HashSet<>();
        adresRepository.findAll().forEach(adresSet::add);
        return adresSet;
    }

    @Override
    public Adres findById(Long aLong) {
        return adresRepository.findById(aLong).orElse(null);
    }

    @Override
    public Adres save(Adres object) {
        return adresRepository.save(object);
    }

    @Override
    public void delete(Adres object) {
        adresRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        adresRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        adresRepository.deleteAll();
    }
}
