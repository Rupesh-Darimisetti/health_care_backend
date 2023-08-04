package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.DoctorDetails;

import java.util.List;
import java.util.Optional;
@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Long> {
    List<DoctorDetails> findByHospitalAccountId(Long hospitalId);
    List<DoctorDetails> findAllByHospitalAccountIsNull(); // Fetch doctors without relation
    List<DoctorDetails> findAllByHospitalAccountIsNotNull(); // Fetch doctors with relation
    // Add custom query methods here if needed
}
