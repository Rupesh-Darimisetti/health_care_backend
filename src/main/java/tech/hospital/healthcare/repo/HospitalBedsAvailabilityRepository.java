package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.HospitalBedsAvailability;

@Repository
public interface HospitalBedsAvailabilityRepository extends JpaRepository<HospitalBedsAvailability, Long> {
    // Add any custom queries or methods if needed
}
