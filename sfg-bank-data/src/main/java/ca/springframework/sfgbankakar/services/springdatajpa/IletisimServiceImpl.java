package ca.springframework.sfgbankakar.services.springdatajpa;


import ca.springframework.sfgbankakar.defaults.BaseDefault;
import ca.springframework.sfgbankakar.dto.IletisimDTO;
import ca.springframework.sfgbankakar.dto.KimlikDTO;
import ca.springframework.sfgbankakar.mapper.IletisimMapper;
import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.model.Kimlik;
import ca.springframework.sfgbankakar.repositories.IletisimRepository;
import ca.springframework.sfgbankakar.services.IletisimService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile("springdatajpa")
public class IletisimServiceImpl implements IletisimService {

    private final IletisimMapper iletisimMapper;
    private final IletisimRepository iletisimRepository;

    public IletisimServiceImpl(IletisimMapper iletisimMapper, IletisimRepository iletisimRepository) {
        this.iletisimMapper = iletisimMapper;
        this.iletisimRepository = iletisimRepository;
    }

    @Override
    public Set<Iletisim> findAll() {
        Set<Iletisim> iletisimSet = new HashSet<>();
        iletisimRepository.findAll().forEach(iletisimSet::add);
        return iletisimSet;
    }

    @Override
    public Iletisim findById(Long aLong) {
        return iletisimRepository.findById(aLong).orElse(null);
    }

    @Override
    public Iletisim save(Iletisim object) {
        return iletisimRepository.save(object);
    }

    @Override
    public void delete(Iletisim object) {
        iletisimRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        iletisimRepository.deleteById(aLong);
    }

    @Override
    public void deleteAll() {
        iletisimRepository.deleteAll();
    }

    @Override
    public List<IletisimDTO> getAllIletisim() {
        return iletisimRepository.findAll()
                .stream()
                .map(iletisim -> {
                    IletisimDTO iletisimDTO = iletisimMapper.iletisimToIletisimDTO(iletisim);
                    return iletisimDTO;
                }).collect(Collectors.toList());
    }

    @Override
    public IletisimDTO getIletisimById(Long id) {
        return iletisimRepository.findById(id)
                .map(iletisimMapper::iletisimToIletisimDTO)
                .orElseThrow();
    }

    @Override
    public IletisimDTO createNewIletisim(IletisimDTO iletisimDTO) {
        return saveAndReturnDTO(iletisimMapper.iletisimDTOtoIletisim(iletisimDTO));
    }

    private IletisimDTO saveAndReturnDTO(Iletisim iletisim) {
        Iletisim savedIletisim = iletisimRepository.save(iletisim);

        IletisimDTO returnDto = iletisimMapper.iletisimToIletisimDTO(savedIletisim);

        return returnDto;
    }

    @Override
    public IletisimDTO patchIletisim(Long id, IletisimDTO iletisimDTO) {
        return iletisimRepository.findById(id)
                .map(iletisim -> {
                    if(!BaseDefault.checkNull(iletisimDTO.getTelefonNo())){
                        iletisim.setTelefonNo(iletisimDTO.getTelefonNo());
                    }
                    if(!BaseDefault.checkNull(iletisimDTO.getEvTelefonNo())){
                        iletisim.setEvTelefonNo(iletisimDTO.getEvTelefonNo());
                    }
                    if(!BaseDefault.checkNull(iletisimDTO.getKimlik())){
                        iletisim.setKimlik(iletisimDTO.getKimlik());
                    }

                    IletisimDTO iletisimDTOreturn = IletisimMapper.INSTANCE.iletisimToIletisimDTO(iletisim);
                    return iletisimDTOreturn;
                })
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public void deleteIletisimById(Long id) {
         iletisimRepository.deleteById(id);
    }
}
