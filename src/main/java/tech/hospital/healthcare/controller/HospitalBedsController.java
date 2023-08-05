package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.model.HospitalBeds;
import tech.hospital.healthcare.repo.HospitalAccountRepository;
import tech.hospital.healthcare.repo.HospitalBedsRepository;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/beds")
public class HospitalBedsController {
    private final HospitalBedsRepository bedsRepository;

    private final HospitalAccountRepository hospitalAccountRepository;
    @Autowired
    public HospitalBedsController(HospitalBedsRepository bedsRepository, HospitalAccountRepository hospitalAccountRepository) {
        this.bedsRepository = bedsRepository;
        this.hospitalAccountRepository = hospitalAccountRepository;
    }

    @GetMapping("/all")
    public List<HospitalBeds> getAllBeds() {
        var hospitalBedsWithRelation = getHospitalBedsWithRelation();
       bedsRepository.save(hospitalBedsWithRelation);
        return bedsRepository.findAll();
    }
    @GetMapping("/without-relation")
    public List<HospitalBeds> getHospitalBedsWithoutRelation() {
        // Fetch doctors with the relation using the repository
        return bedsRepository.findAllByHospitalAccountIsNull();
    }
    @GetMapping("/with-relation")
    public HospitalBeds getHospitalBedsWithRelation() {
        // Fetch doctors with the relation using the repository
        return bedsRepository.findAllByHospitalAccountIsNotNull();
    }
    @GetMapping("/{serialNum}")
    public ResponseEntity<HospitalBeds> getBedsBySerialNumber(@PathVariable Long serialNum) {
        Optional<HospitalBeds> bedsOptional = bedsRepository.findById(serialNum);
        return bedsOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalBeds> createBeds(@RequestBody HospitalBeds beds) {
        HospitalAccount hospitalAccount= hospitalAccountRepository.save(beds.getHospitalAccount());
        HospitalBeds savedBeds = bedsRepository.save(beds);
        ResponseEntity.ok(hospitalAccount);
        return ResponseEntity.ok(savedBeds);
    }

    @PutMapping("update/{serialNum}")
    public ResponseEntity<HospitalBeds> updateBeds(@PathVariable Long serialNum, @RequestBody HospitalBeds beds) {
        Optional<HospitalBeds> bedsOptional = bedsRepository.findById(serialNum);
        if (bedsOptional.isPresent()) {
            HospitalBeds existingBeds = bedsOptional.get();
            existingBeds.setH_regular_beds(beds.getH_regular_beds());
            existingBeds.setH_icu_beds(beds.getH_icu_beds());
            existingBeds.setH_pediatric_beds(beds.getH_pediatric_beds());
            existingBeds.setH_maternity_beds(beds.getH_maternity_beds());
            existingBeds.setH_birthing_beds(beds.getH_birthing_beds());
            existingBeds.setH_orthopedic_beds(beds.getH_orthopedic_beds());
            existingBeds.setH_home_care_beds(beds.getH_home_care_beds());
            existingBeds.setH_emergency_beds(beds.getH_emergency_beds());
            // Set other properties as needed
            HospitalBeds updatedBeds = bedsRepository.save(existingBeds);
            return ResponseEntity.ok(updatedBeds);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{serialNum}")
    public ResponseEntity<Void> deleteBeds(@PathVariable Long serialNum) {
        bedsRepository.deleteById(serialNum);
        return ResponseEntity.noContent().build();
    }
}
