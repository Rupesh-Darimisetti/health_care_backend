package tech.hospital.healthcare.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.HospitalAccountRepository;

@Service
public class HospitalAccountService {
    private final HospitalAccountRepository hospitalRepository;

    @Autowired
    public HospitalAccountService(HospitalAccountRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    // Add methods for business logic related to HospitalAccount entity

    public HospitalAccount saveHospital(HospitalAccount hospital) {
        return hospitalRepository.save(hospital);
    }

    public HospitalAccount getHospitalById(Long hId) {
        return hospitalRepository.findById(hId).orElse(null);
    }

    public void deleteHospital(Long hId) {
        hospitalRepository.deleteById(hId);
    }

    // Add more methods as needed


//    public HospitalAccount addHospitalAccount(HospitalAccount hospitalAccount){
//        return hospitalAccountRepo.save(hospitalAccount);
//    }

//    public List<HospitalAccount> findAllHospitalAccount(){
//        return hospitalAccountRepo.findAll();
//    }
//
//    public HospitalAccount updateHospitalAccount(HospitalAccount hospitalAccount){
//        return hospitalAccountRepo.save(hospitalAccount);
//    }
//
//    public HospitalAccount findHospitalAccountById(Long h_id){
//        return hospitalAccountRepo.findHospitalAccountById(h_id)
//                .orElseThrow(()-> new UserNotFoundException("Hospital by id " + h_id + " was not found."));
//    }
//
//    public void deleteHospitalAccount(Long h_id){
//        hospitalAccountRepo.deleteHospitalAccountById(h_id);
//    }
}
