package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hospital.healthcare.model.DoctorDetails;

import java.util.Optional;

public interface DoctorDetailsRepo extends JpaRepository<DoctorDetails,Long> {
    void deleteDoctorDetailsById(Long doctor_id);
    Optional<DoctorDetails> findDoctorDetailsById(Long doctor_id);
}
