package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.HospitalAccountRepository;
import tech.hospital.healthcare.service.HospitalAccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalAccountController {
    private final HospitalAccountService hospitalAccountService;

    @Autowired
    public HospitalAccountController(HospitalAccountService hospitalAccountService) {
        this.hospitalAccountService = hospitalAccountService;
    }

    @GetMapping("/all")
    public List<HospitalAccount> getAllHospitals() {
        List<HospitalAccount> hospitalAccounts = hospitalAccountService.findAllHospitalAccounts();
        return new ResponseEntity<>(hospitalAccounts,HttpStatus.OK).getBody();
    }

    @GetMapping("/{h_id}")
    public ResponseEntity<HospitalAccount> getHospitalById(@PathVariable Integer h_id) {
        HospitalAccount hospitalAccount = hospitalAccountService.getHospitalById(h_id);
        return new ResponseEntity<>(hospitalAccount,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalAccount> createHospital(@RequestBody HospitalAccount hospital) {
        HospitalAccount newHospitalAccount = hospitalAccountService.addHospitalAccount(hospital);
        return new ResponseEntity<>(newHospitalAccount,HttpStatus.CREATED);
    }

    @PutMapping("update/{h_id}")
    public ResponseEntity<HospitalAccount> updateHospital(@PathVariable Integer hospitalId, @RequestBody HospitalAccount hospital) {
        HospitalAccount updateHospitalAccount=hospitalAccountService.updateHospitalAccount(hospitalId,hospital);
        return new ResponseEntity<>(updateHospitalAccount,HttpStatus.OK);
        //        Optional<HospitalAccount> hospitalOptional = hospitalAccountService.findById(hospitalId);
//        if (hospitalOptional.isPresent()) {
//            HospitalAccount existingHospital = hospitalOptional.get();
//            existingHospital.setHName(hospital.getHName());
//            existingHospital.setHStreet(hospital.getHStreet());
//            // Set other properties as needed
//            HospitalAccount updatedHospital = hospitalAccountService.save(existingHospital);
//            return ResponseEntity.ok(updatedHospital);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @DeleteMapping("delete/{h_id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Integer hospitalId) {
        hospitalAccountService.deleteHospitalAccountById(hospitalId);
//        return ResponseEntity.noContent().build();
    return new ResponseEntity<>(HttpStatus.OK);
    }
}
