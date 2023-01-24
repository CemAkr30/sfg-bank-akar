package ca.springframework.sfgbankakar.services.map;

import ca.springframework.sfgbankakar.model.Iletisim;
import ca.springframework.sfgbankakar.services.Crudservice;


public interface IletisimService   extends Crudservice<Iletisim,Long>  {

    Iletisim findByTelefonNo(String telefonNo);


//    Iletisim findById(Long id);
//    Iletisim save(Iletisim Iletisim);
//    Set<Iletisim> findAll();

}
