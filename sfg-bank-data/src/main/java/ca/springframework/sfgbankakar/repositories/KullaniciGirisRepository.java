package ca.springframework.sfgbankakar.repositories;

import ca.springframework.sfgbankakar.model.KullaniciGiris;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KullaniciGirisRepository extends JpaRepository<KullaniciGiris,Long> {

}
