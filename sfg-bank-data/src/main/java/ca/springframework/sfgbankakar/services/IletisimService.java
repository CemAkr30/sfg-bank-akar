package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.IletisimDTO;
import ca.springframework.sfgbankakar.model.Iletisim;

import java.util.List;


public interface IletisimService   extends Crudservice<Iletisim,Long>  {


    List<IletisimDTO> getAllIletisim();

    IletisimDTO getIletisimById(Long id);

    IletisimDTO createNewIletisim(IletisimDTO customerDTO);

    IletisimDTO patchIletisim(Long id, IletisimDTO customerDTO);

    void deleteIletisimById(Long id);
}
