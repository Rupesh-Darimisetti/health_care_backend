package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.HospitalBeds;
import java.util.Optional;

@Repository
public interface HospitalBedsRepository extends JpaRepository<HospitalBeds, Long> {
    // Add any custom queries or methods if needed

}
