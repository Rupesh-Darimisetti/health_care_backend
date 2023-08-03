package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.hospital.healthcare.model.GeneralPublicUser;

@Repository
public interface GeneralPublicUserRepository extends JpaRepository<GeneralPublicUser, Long> {

}
