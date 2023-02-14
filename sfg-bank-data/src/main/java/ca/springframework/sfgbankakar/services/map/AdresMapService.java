package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.mapper.AdresMapper;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.services.AdresService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//implements Crudservice<Adres,Long> çıkartıyoruz üst sınıf veriyoruz
@Service
@Profile({"default", "map"})
public class AdresMapService extends AbstractMapService<Adres,Long> implements AdresService {

    //Jpa taklit ettik, crudService methodları override ettirdi abstractmapservice de dbmiz gibi

    private final AdresMapper adresMapper;

    public AdresMapService(AdresMapper adresMapper) {
        this.adresMapper = adresMapper;
    }

    @Override
    public Set<Adres> findAll() {
        return super.findAll();
    }

//    @Override
//    public Adres print() {
//        return new Adres();
//    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void deleteAll() {
        super.deleteAll();
    }

    @Override
    public void delete(Adres object) {
        super.delete(object);
    }

    @Override
    public Adres save(Adres object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Adres findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<AdresDTO> getAllAdres() {
        return super.findAll()
                .stream()
                .map(adres ->{
                    AdresDTO adresDTO = adresMapper.adresToAdresDTO(adres);
                    return adresDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public AdresDTO getAdresById(Long id) {
        AdresDTO adresDTO = adresMapper.adresToAdresDTO(super.findById(id));
        return adresDTO;
    }

    @Override
    public AdresDTO createNewAdres(AdresDTO adresDTO) {
        Adres adres = adresMapper.adresDTOtoAdres(adresDTO);
        AdresDTO adresDTOj = adresMapper.adresToAdresDTO(super.createNew(adres));
        return adresDTOj;
    }

    @Override
    public AdresDTO patchAdres(Long id, AdresDTO adresDTO) {
        return super.findAll()
                .stream()
                .map(adres -> {
                    if(id.equals(adres.getId())){
                        if(adresDTO.getBeyanAdres()!=null){
                            adres.setBeyanAdres(adresDTO.getBeyanAdres());
                        }
                        if(adresDTO.getEmail()!=null){
                            adres.setEmail(adresDTO.getEmail());
                        }
                        AdresDTO adresDTOj = adresMapper.adresToAdresDTO(adres);
                        return adresDTOj;
                    }
                    return null;
                }).collect(Collectors.toList()).get(0);
    }

    @Override
    public void deleteAdresById(Long id) {
        super.deleteById(id);
    }
}
