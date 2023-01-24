package ca.springframework.sfgbankakar.services;


import ca.springframework.sfgbankakar.model.Kimlik;

public interface KimlikService {

    Kimlik findById(Long l);

    void save(Kimlik kimlik);
}
