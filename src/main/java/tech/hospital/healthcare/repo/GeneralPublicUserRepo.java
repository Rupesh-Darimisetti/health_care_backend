package tech.hospital.healthcare.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.hospital.healthcare.model.GeneralPublicUser;

import java.util.Optional;

public interface GeneralPublicUserRepo extends JpaRepository<GeneralPublicUser,Long> {
    void deleteGeneralPublicById(Long user_id);
    Optional<GeneralPublicUser> findGeneralPublicUserById(Long user_id);
}
