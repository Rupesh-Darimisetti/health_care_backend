package tech.hospital.healthcare.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.exception.UserNotFoundException;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.HospitalAccountRepository;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class HospitalAccountService {
    private final HospitalAccountRepository hospitalAccountRepository;
    @Autowired
    public HospitalAccountService(HospitalAccountRepository hospitalAccountRepository) {
        this.hospitalAccountRepository = hospitalAccountRepository;
    }
    public HospitalAccount findHospitalAccountById(Integer hId){
        // using streaming to check all hospital ids to match the passed id
        return findAllHospitalAccounts().stream()
                .filter(hospitalAccount -> hospitalAccount.getH_id().equals(hId))
                .findFirst()
                .orElse(null);
    }
    public HospitalAccount getHospitalById(Integer h_id) {
        HospitalAccount foundAccount= findHospitalAccountById(h_id);
        return Objects.requireNonNull(foundAccount, "Hospital by id " + h_id + " was not found.");
    }

    public HospitalAccount addHospitalAccount(HospitalAccount hospitalAccount){
        return hospitalAccountRepository.save(hospitalAccount);
    }

    public List<HospitalAccount> findAllHospitalAccounts(){
        return hospitalAccountRepository.findAll();
    }

    public HospitalAccount updateHospitalAccount(Integer h_id, HospitalAccount updatedHospitalAccount){
        HospitalAccount foundAccount = findHospitalAccountById(h_id);

        if (foundAccount == null) {
            throw new UserNotFoundException("Hospital Account with h_id " + h_id + " not found");
        }

        // updating all the fields with new values
        foundAccount.setId(foundAccount.getId());
        foundAccount.setH_id(updatedHospitalAccount.getH_id());
        foundAccount.setH_name(updatedHospitalAccount.getH_name());
        foundAccount.setH_city(updatedHospitalAccount.getH_city());
        foundAccount.setH_email(updatedHospitalAccount.getH_email());
        foundAccount.setH_state(updatedHospitalAccount.getH_state());
        foundAccount.setH_street(updatedHospitalAccount.getH_street());
        foundAccount.setH_website(updatedHospitalAccount.getH_website());
        foundAccount.setH_password(updatedHospitalAccount.getH_password());
        foundAccount.setH_zip_code(updatedHospitalAccount.getH_zip_code());
        foundAccount.setHLabFacility(updatedHospitalAccount.getHLabFacility());
        foundAccount.setH_contact_number(updatedHospitalAccount.getH_contact_number());
        foundAccount.setHScanningFacility(updatedHospitalAccount.getHScanningFacility());
        foundAccount.setHInsuranceAcceptance(updatedHospitalAccount.getHInsuranceAcceptance());
        // return the updated data
        return hospitalAccountRepository.save(foundAccount);
    }

    public void deleteHospitalAccountById(Integer h_id){
        var id = findHospitalAccountById(h_id).getId();
         hospitalAccountRepository.deleteHospitalAccountById(id);
    }
}
