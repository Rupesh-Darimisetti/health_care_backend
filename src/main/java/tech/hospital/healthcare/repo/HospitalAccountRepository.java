package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.HospitalAccount;


@Repository
public interface HospitalAccountRepository extends JpaRepository<HospitalAccount, Long> {
    //    delete user based on id from the iterated values of h_id
    void deleteHospitalAccountById(Long id);
}
