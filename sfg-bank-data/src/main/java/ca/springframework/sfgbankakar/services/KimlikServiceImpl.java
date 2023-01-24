package ca.springframework.sfgbankakar.services;


import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import org.springframework.stereotype.Service;

@Service
public class KimlikServiceImpl implements KimlikService {

    private final KimlikRepository kimlikRepository;

    public KimlikServiceImpl(KimlikRepository kimlikRepository){
        this.kimlikRepository = kimlikRepository;
    }

    @Override
    public Kimlik findById(Long l) {
        return null;
    }

    @Override
    public void save(Kimlik kimlik) {

    }
}
