package ca.springframework.sfgbankakar.repositories;


import ca.springframework.sfgbankakar.model.Musteri;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusteriRepository extends JpaRepository<Musteri, Long> {

    Musteri findByHesapNo(String hesapNo);
    Musteri findByIbanNo(String ibanNo);

}
