package ca.springframework.sfgbankakar.services.springdatajpa;

import ca.springframework.sfgbankakar.defaults.BaseDefault;
import ca.springframework.sfgbankakar.dto.KimlikDTO;
import ca.springframework.sfgbankakar.mapper.KimlikMapper;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.KimlikRepository;
import ca.springframework.sfgbankakar.services.KimlikService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("springdatajpa") // KimlikService türeyen 2 class biri KimlikServiceImpl diğeri KimlikMapService Qualifer vermek yerine injection yaparken
//profile olanlara göre injection gerçekleştir. MapService ile fake jpa yapmıştık  mantığı anlamak için ancak şimdi jpa kullanarak
//hibernate tarafına mapleri göndererek crud işlemler yapılacaktır.
public class KimlikServiceImpl implements KimlikService {


    private final KimlikMapper kimlikMapper;
    private final KimlikRepository kimlikRepository;

    public KimlikServiceImpl(KimlikMapper kimlikMapper, KimlikRepository kimlikRepository) {
        this.kimlikMapper = kimlikMapper;
        this.kimlikRepository = kimlikRepository;
    }

    @Override
    public Kimlik findByAdiSoyadi(String adiSoyadi) {
        return kimlikRepository.findByAdiSoyadi(adiSoyadi);
    }

    @Override
    public Kimlik findByKimlikNo(String kimlikNo) {
        return kimlikRepository.findByKimlikNo(kimlikNo);
    }

    @Override
    public List<KimlikDTO> getAllKimlik() {
        return kimlikRepository.findAll()
                .stream()
                .map(kimlik -> {
                    KimlikDTO kimlikDTO = kimlikMapper.INSTANCE.kimlikToKimlikDTO(kimlik);
                    return kimlikDTO;
                })
                .collect(Collectors.toList());
    }

    @Override
    public KimlikDTO getKimlikById(Long id) {
        return kimlikRepository.findById(id)
                .map(kimlikMapper::kimlikToKimlikDTO)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public KimlikDTO createNewKimlik(KimlikDTO kimlikDTO) {
        return  saveAndReturnDTO(kimlikMapper.kimlikDTOtoKimlik(kimlikDTO));
    }

    private KimlikDTO saveAndReturnDTO(Kimlik kimlik) {
        Kimlik savedKimlik = kimlikRepository.save(kimlik);

        KimlikDTO returnDto = kimlikMapper.kimlikToKimlikDTO(savedKimlik);

        return returnDto;
    }

    @Override
    public KimlikDTO patchKimlik(Long id, KimlikDTO kimlikDTO) {
        return kimlikRepository.findById(id)
                .map(kimlik -> {
                    if(!BaseDefault.checkNull(kimlikDTO.getKimlikNo())){
                        kimlik.setKimlikNo(kimlikDTO.getKimlikNo());
                    }
                    if(!BaseDefault.checkNull(kimlikDTO.getCinsiyet())){
                        kimlik.setCinsiyet(kimlikDTO.getCinsiyet());
                    }
                    if(!BaseDefault.checkNull(kimlikDTO.getAdiSoyadi())){
                        kimlik.setAdiSoyadi(kimlikDTO.getAdiSoyadi());
                    }
                    if(!BaseDefault.checkNull(kimlikDTO.getKullaniciGiris())){
                        kimlik.setKullaniciGiris(kimlikDTO.getKullaniciGiris());
                    }
                    if(BaseDefault.isNotEmptySet(kimlikDTO.getIletisimSet())){
                        kimlikDTO.getIletisimSet()
                                .forEach(iletisim -> kimlik.addIletisimSet(iletisim));
                    }
                    if(BaseDefault.isNotEmptySet(kimlikDTO.getAdresSet())){
                       kimlikDTO.getAdresSet()
                               .forEach(adres -> kimlik.addAdresSet(adres));
                    }
                    if(!BaseDefault.checkNull(kimlikDTO.getKullaniciGiris())){
                        kimlik.setKullaniciGiris(kimlikDTO.getKullaniciGiris());
                    }

                   KimlikDTO kimlikDTO1 = kimlikMapper.kimlikToKimlikDTO(kimlik);

                    return kimlikDTO1;
                }).orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteKimlikById(Long id) {
        kimlikRepository.deleteById(id);
    }


    @Override
    public Set<Kimlik> findAll() {
        Set<Kimlik> kimlikSet = new HashSet<>();
   //     kimlikRepository.findAll().forEach(kimlikSet::add);
        kimlikRepository.findAll().iterator().forEachRemaining(kimlikSet::add);
        return kimlikSet;
    }

    @Override
    public Kimlik findById(Long aLong) {
        return kimlikRepository.findById(aLong).orElse(null);
    }

    @Override
    public Kimlik save(Kimlik object) {
        return kimlikRepository.save(object);
    }

    @Override
    public void delete(Kimlik object) {
        kimlikRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        kimlikRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        kimlikRepository.deleteAll();
    }
}
