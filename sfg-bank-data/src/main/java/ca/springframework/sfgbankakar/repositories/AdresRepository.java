package ca.springframework.sfgbankakar.repositories;

import ca.springframework.sfgbankakar.model.Adres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresRepository extends JpaRepository<Adres,Long> {

}
