package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.HospitalAccountRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalAccountController {
    private final HospitalAccountRepository hospitalRepository;

    @Autowired
    public HospitalAccountController(HospitalAccountRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @GetMapping("/all")
    public List<HospitalAccount> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    @GetMapping("/{h_id}")
    public ResponseEntity<HospitalAccount> getHospitalById(@PathVariable Long h_id) {
        Optional<HospitalAccount> hospitalOptional = hospitalRepository.findById(h_id);
        return hospitalOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalAccount> createHospital(@RequestBody HospitalAccount hospital) {
        HospitalAccount savedHospital = hospitalRepository.save(hospital);
        return ResponseEntity.ok(savedHospital);
    }

    @PutMapping("update/{h_id}")
    public ResponseEntity<HospitalAccount> updateHospital(@PathVariable Long hospitalId, @RequestBody HospitalAccount hospital) {
        Optional<HospitalAccount> hospitalOptional = hospitalRepository.findById(hospitalId);
        if (hospitalOptional.isPresent()) {
            HospitalAccount existingHospital = hospitalOptional.get();
            existingHospital.setHName(hospital.getHName());
            existingHospital.setHStreet(hospital.getHStreet());
            // Set other properties as needed
            HospitalAccount updatedHospital = hospitalRepository.save(existingHospital);
            return ResponseEntity.ok(updatedHospital);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{h_id}")
    public ResponseEntity<Void> deleteHospital(@PathVariable Long hospitalId) {
        hospitalRepository.deleteById(hospitalId);
        return ResponseEntity.noContent().build();
    }
}
