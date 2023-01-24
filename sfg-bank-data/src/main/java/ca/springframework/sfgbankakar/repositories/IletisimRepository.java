package ca.springframework.sfgbankakar.repositories;


import ca.springframework.sfgbankakar.model.Iletisim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IletisimRepository extends JpaRepository<Iletisim,Long> {

}
