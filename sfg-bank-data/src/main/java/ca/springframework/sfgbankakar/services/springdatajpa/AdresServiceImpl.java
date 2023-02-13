package ca.springframework.sfgbankakar.services.springdatajpa;


import ca.springframework.sfgbankakar.dto.AdresDTO;
import ca.springframework.sfgbankakar.mapper.AdresMapper;
import ca.springframework.sfgbankakar.model.Adres;
import ca.springframework.sfgbankakar.repositories.AdresRepository;
import ca.springframework.sfgbankakar.services.AdresService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("springdatajpa")
public class AdresServiceImpl implements AdresService {

    private final AdresMapper adresMapper;
    private final AdresRepository adresRepository;

    public AdresServiceImpl(AdresMapper adresMapper, AdresRepository adresRepository) {
        this.adresMapper = adresMapper;
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

    @Override
    public List<AdresDTO> getAllAdres() {
        return adresRepository.findAll()
                    .stream()
                    .map(adres -> {
                        AdresDTO adresDTO = adresMapper.INSTANCE.adresToAdresDTO(adres);
                        return adresDTO;
                    })
                    .collect(Collectors.toList());
    }

    @Override
    public AdresDTO getAdresById(Long id) {
        return adresRepository.findById(id)
                            .map(adresMapper::adresToAdresDTO) // gellAllAdres benzer mapleme yapar adresToAdresDTO türe göre adresmapper yap
                             .orElseThrow(RuntimeException::new) ;
    }

    @Override
    public AdresDTO createNewAdres(AdresDTO adresDTO) {
        return saveAndReturnDTO(adresMapper.adresDTOtoAdres(adresDTO));
    }

    private AdresDTO saveAndReturnDTO(Adres adres) {
        Adres savedAdres = adresRepository.save(adres);

        AdresDTO returnDto = adresMapper.adresToAdresDTO(savedAdres);

        return returnDto;
    }

    @Override
    public AdresDTO patchAdres(Long id, AdresDTO adresDTO) {
        //@patch ile sadece bir alan,bir kayit güncellenirse mantıklıo
        return adresRepository.findById(id)
                    .map(adres -> {
                        if(adresDTO.getBeyanAdres()!=null){
                            adres.setBeyanAdres(adresDTO.getBeyanAdres());
                        }
                        if(adresDTO.getEmail()!=null){
                            adres.setEmail(adresDTO.getEmail());
                        }
                        AdresDTO returnDTO = AdresMapper.INSTANCE.adresToAdresDTO(adres);
                        return returnDTO;
                    })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteAdresById(Long id) {
            adresRepository.deleteById(id);
    }
}
