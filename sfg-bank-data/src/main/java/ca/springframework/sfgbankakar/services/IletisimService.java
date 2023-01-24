package ca.springframework.sfgbankakar.services;


import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.Kimlik;

public interface IletisimService {
    void save(Iletisim adres, Kimlik kimlik);
}
