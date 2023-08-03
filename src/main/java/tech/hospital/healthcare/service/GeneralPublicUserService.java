package tech.hospital.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.model.GeneralPublicUser;
import tech.hospital.healthcare.repo.GeneralPublicUserRepository;

@Service
public class GeneralPublicUserService {
    private final GeneralPublicUserRepository userRepository;

    @Autowired
    public GeneralPublicUserService(GeneralPublicUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Add methods for business logic related to GeneralPublicUser entity

    public GeneralPublicUser saveUser(GeneralPublicUser user) {
        return userRepository.save(user);
    }

    public GeneralPublicUser getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    // Add more methods as needed
//    public List<GeneralPublicUser> findAllGeneralPublicUsers(){
//        return generalPublicUserRepo.findAll();
//    }
//
//    public GeneralPublicUser updateGeneralPublicUser(GeneralPublicUser generalPublicUser){
//        return generalPublicUserRepo.save(generalPublicUser);
//    }
//    public GeneralPublicUser findGeneralPublicUserById(Long user_id){
//        return generalPublicUserRepo.findGeneralPublicUserById(user_id)
//                .orElseThrow(()-> new UserNotFoundException("user by id " + user_id +" was not found."));
//    }
//
//    public void deleteGeneralPublicUser(Long user_id){
//        generalPublicUserRepo.deleteGeneralPublicById(user_id);
//    }
}
