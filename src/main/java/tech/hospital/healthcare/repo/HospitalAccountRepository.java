package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.HospitalAccount;

import java.util.Optional;

@Repository
public interface HospitalAccountRepository extends JpaRepository<HospitalAccount, Long> {
    // Add any custom queries or methods if needed

}
