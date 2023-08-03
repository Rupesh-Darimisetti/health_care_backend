package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalBeds;
import tech.hospital.healthcare.repo.HospitalBedsRepository;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/beds")
public class HospitalBedsController {
    private final HospitalBedsRepository bedsRepository;

    @Autowired
    public HospitalBedsController(HospitalBedsRepository bedsRepository) {
        this.bedsRepository = bedsRepository;
    }

    @GetMapping("/all")
    public List<HospitalBeds> getAllBeds() {
        return bedsRepository.findAll();
    }

    @GetMapping("/{serialNum}")
    public ResponseEntity<HospitalBeds> getBedsBySerialNumber(@PathVariable Long serialNum) {
        Optional<HospitalBeds> bedsOptional = bedsRepository.findById(serialNum);
        return bedsOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalBeds> createBeds(@RequestBody HospitalBeds beds) {
        HospitalBeds savedBeds = bedsRepository.save(beds);
        return ResponseEntity.ok(savedBeds);
    }

    @PutMapping("update/{serialNum}")
    public ResponseEntity<HospitalBeds> updateBeds(@PathVariable Long serialNum, @RequestBody HospitalBeds beds) {
        Optional<HospitalBeds> bedsOptional = bedsRepository.findById(serialNum);
        if (bedsOptional.isPresent()) {
            HospitalBeds existingBeds = bedsOptional.get();
            existingBeds.setHRegularBeds(beds.getHRegularBeds());
            existingBeds.setHIcuBeds(beds.getHIcuBeds());
            // Set other properties as needed
            HospitalBeds updatedBeds = bedsRepository.save(existingBeds);
            return ResponseEntity.ok(updatedBeds);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{serialNum}")
    public ResponseEntity<Void> deleteBeds(@PathVariable Long serialNum) {
        bedsRepository.deleteById(serialNum);
        return ResponseEntity.noContent().build();
    }
}
