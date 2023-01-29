package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.model.KullaniciGiris;
import ca.springframework.sfgbankakar.repositories.KullaniciGirisRepository;
import ca.springframework.sfgbankakar.services.KullaniciGirisService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class KullaniciGirisServiceImpl implements KullaniciGirisService {

    private final KullaniciGirisRepository kullaniciGirisRepository;

    public KullaniciGirisServiceImpl(KullaniciGirisRepository kullaniciGirisRepository) {
        this.kullaniciGirisRepository = kullaniciGirisRepository;
    }


    @Override
    public Set<KullaniciGiris> findAll() {
        Set<KullaniciGiris> kullaniciGirisSet = new HashSet<>();
        kullaniciGirisRepository.findAll().forEach(kullaniciGirisSet::add);
        return kullaniciGirisSet;
    }

    @Override
    public KullaniciGiris findById(Long aLong) {
        return kullaniciGirisRepository.findById(aLong).orElse(null);
    }

    @Override
    public KullaniciGiris save(KullaniciGiris object) {
        return kullaniciGirisRepository.save(object);
    }

    @Override
    public void delete(KullaniciGiris object) {
        kullaniciGirisRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        kullaniciGirisRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        kullaniciGirisRepository.deleteAll();
    }
}
