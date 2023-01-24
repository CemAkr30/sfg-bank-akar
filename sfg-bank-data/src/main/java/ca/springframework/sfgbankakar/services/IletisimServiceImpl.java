package ca.springframework.sfgbankakar.services;


import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.IletisimRepository;
import org.springframework.stereotype.Service;

@Service
public class IletisimServiceImpl implements  IletisimService {

    private final IletisimRepository iletisimRepository;

    public IletisimServiceImpl(IletisimRepository iletisimRepository) {
        this.iletisimRepository = iletisimRepository;
    }

    @Override
    public void save(Iletisim adres, Kimlik kimlik) {

    }
}
