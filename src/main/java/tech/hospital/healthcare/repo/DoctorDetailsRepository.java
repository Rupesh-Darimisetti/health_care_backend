package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.DoctorDetails;

import java.util.Optional;
@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Long> {
    // Add custom query methods here if needed
}
