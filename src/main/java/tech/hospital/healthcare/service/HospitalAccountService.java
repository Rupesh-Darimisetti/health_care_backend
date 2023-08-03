package tech.hospital.healthcare.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.exception.UserNotFoundException;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.HospitalAccountRepository;

import java.util.List;

@Service
@Transactional
public class HospitalAccountService {
    private final HospitalAccountRepository hospitalAccountRepository;
    @Autowired
    public HospitalAccountService(HospitalAccountRepository hospitalAccountRepository) {
        this.hospitalAccountRepository = hospitalAccountRepository;
    }

    public HospitalAccount getHospitalById(Integer h_id) {
        return hospitalAccountRepository.findHospitalAccountById(h_id)
                .orElseThrow(()-> new UserNotFoundException("Hospital by id " + h_id + " was not found."));
    }

    public HospitalAccount addHospitalAccount(HospitalAccount hospitalAccount){
        return hospitalAccountRepository.save(hospitalAccount);
    }

    public List<HospitalAccount> findAllHospitalAccounts(){
        return hospitalAccountRepository.findAll();
    }

    public HospitalAccount updateHospitalAccount(Integer hospitalId, HospitalAccount hospitalAccount){
        return hospitalAccountRepository.save(hospitalAccount);
    }



    public void deleteHospitalAccountById(Integer h_id){
        hospitalAccountRepository.deleteHospitalAccountById(h_id);
    }
}
