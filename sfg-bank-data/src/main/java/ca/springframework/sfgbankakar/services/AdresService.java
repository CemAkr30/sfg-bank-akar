package ca.springframework.sfgbankakar.services;


import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.model.Kimlik;

public interface AdresService {

    void save(Adres adres, Kimlik kimlik);
}
