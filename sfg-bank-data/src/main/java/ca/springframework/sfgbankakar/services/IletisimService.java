package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.model.Iletisim;


public interface IletisimService   extends Crudservice<Iletisim,Long>  {

    Iletisim findByTelefonNo(String telefonNo);


//    Iletisim findById(Long id);
//    Iletisim save(Iletisim Iletisim);
//    Set<Iletisim> findAll();

}
