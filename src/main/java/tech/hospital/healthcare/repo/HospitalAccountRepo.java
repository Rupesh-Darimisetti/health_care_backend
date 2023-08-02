package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hospital.healthcare.model.HospitalAccount;

import java.util.Optional;

public interface HospitalAccountRepo extends JpaRepository<HospitalAccount,Long> {

    Optional<HospitalAccount> findHospitalAccountById(Long hId);

    void deleteHospitalAccountById(Long hId);
}
