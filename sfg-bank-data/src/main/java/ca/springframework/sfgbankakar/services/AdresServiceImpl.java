package ca.springframework.sfgbankakar.services;


import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.AdresRepository;
import org.springframework.stereotype.Service;

@Service
public class AdresServiceImpl implements AdresService {

    private final AdresRepository adresRepository;

    public AdresServiceImpl(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }

    @Override
    public void save(Adres adres, Kimlik kimlik) {

    }
}
