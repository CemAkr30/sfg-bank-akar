package ca.springframework.sfgbankakar.repositories;

import ca.springframework.sfgbankakar.model.TransferLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferLogRepository extends JpaRepository<TransferLog, Long> {
}
