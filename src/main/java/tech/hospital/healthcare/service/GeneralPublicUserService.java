package tech.hospital.healthcare.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.exception.UserNotFoundException;
import tech.hospital.healthcare.model.GeneralPublicUser;
import tech.hospital.healthcare.repo.GeneralPublicUserRepo;

import java.util.UUID;
import java.util.List;

@Service
@Transactional
public class GeneralPublicUserService {
    private final GeneralPublicUserRepo generalPublicUserRepo;
    @Autowired
    public GeneralPublicUserService(GeneralPublicUserRepo generalPublicUserRepo){
        this.generalPublicUserRepo = generalPublicUserRepo;
    }

    public GeneralPublicUser addGeneralPublicUser(GeneralPublicUser generalPublicUser){
        generalPublicUser.setUserCode(UUID.randomUUID().toString());
        return generalPublicUserRepo.save(generalPublicUser);
    }


    public List<GeneralPublicUser> findAllGeneralPublicUsers(){
        return generalPublicUserRepo.findAll();
    }

    public GeneralPublicUser updateGeneralPublicUser(GeneralPublicUser generalPublicUser){
        return generalPublicUserRepo.save(generalPublicUser);
    }
    public GeneralPublicUser findGeneralPublicUserById(Long user_id){
        return generalPublicUserRepo.findGeneralPublicUserById(user_id)
                .orElseThrow(()-> new UserNotFoundException("user by id " + user_id +" was not found."));
    }

    public void deleteGeneralPublicUser(Long user_id){
        generalPublicUserRepo.deleteGeneralPublicById(user_id);
    }
}
