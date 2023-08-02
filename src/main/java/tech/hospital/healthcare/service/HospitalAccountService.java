package tech.hospital.healthcare.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.exception.UserNotFoundException;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.HospitalAccountRepo;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalAccountService {
    private final HospitalAccountRepo hospitalAccountRepo;
    @Autowired
        public HospitalAccountService(HospitalAccountRepo hospitalAccountRepo) {
        this.hospitalAccountRepo = hospitalAccountRepo;
    }
    public HospitalAccount addHospitalAccount(HospitalAccount hospitalAccount){
        hospitalAccount.setHCode(UUID.randomUUID().toString());
        return hospitalAccountRepo.save(hospitalAccount);
    }

    public List<HospitalAccount> findAllHospitalAccount(){
        return hospitalAccountRepo.findAll();
    }

    public HospitalAccount updateHospitalAccount(HospitalAccount hospitalAccount){
        return hospitalAccountRepo.save(hospitalAccount);
    }

    public HospitalAccount findHospitalAccountById(Long h_id){
        return hospitalAccountRepo.findHospitalAccountById(h_id)
                .orElseThrow(()-> new UserNotFoundException("Hospital by id " + h_id + " was not found."));
    }

    public void deleteHospitalAccount(Long h_id){
        hospitalAccountRepo.deleteHospitalAccountById(h_id);
    }
}
