package ca.springframework.sfgbankakar.services;

import ca.springframework.sfgbankakar.dto.BakiyeTransferDTO;
import ca.springframework.sfgbankakar.dto.MusteriDTO;
import ca.springframework.sfgbankakar.model.Musteri;

import java.util.List;


public interface MusteriService extends Crudservice<Musteri,Long>  {

    Musteri findByHesapNo(String hesapNo);
    Musteri findByIbanNo(String ibanNo);

    List<MusteriDTO> getAllMusteri();

    MusteriDTO getMusteriById(Long id);

    MusteriDTO createNewMusteri(Long kimlikId,MusteriDTO musteriDTO);

    MusteriDTO patchMusteri(Long id, MusteriDTO musteriDTO);

    void transferBakiye(BakiyeTransferDTO bakiyeTransferDTO);

    void deleteMusteriById(Long id);
}
