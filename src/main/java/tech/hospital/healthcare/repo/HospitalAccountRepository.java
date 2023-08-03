package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.HospitalAccount;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface HospitalAccountRepository extends JpaRepository<HospitalAccount, Long> {

    // Add any custom queries or methods if needed
    Optional<HospitalAccount> findHospitalAccountById(Integer h_id);

    void deleteHospitalAccountById(Integer h_id);

}
