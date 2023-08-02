package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.model.HospitalBeds;

import java.util.Optional;

public interface HospitalBedsRepo extends JpaRepository<HospitalBeds,Long> {
    Optional<HospitalBeds> findHospitalBedsById(Long serial_num);

    void deleteHospitalBedsById(Long serialNum);
}
