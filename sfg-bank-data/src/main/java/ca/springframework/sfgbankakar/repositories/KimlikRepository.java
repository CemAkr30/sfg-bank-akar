package ca.springframework.sfgbankakar.repositories;


import ca.springframework.sfgbankakar.model.Kimlik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KimlikRepository  extends JpaRepository<Kimlik,Long> {
    Kimlik findByAdiSoyadi(String adiSoyadi);
}
