package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalBedsAvailability;
import tech.hospital.healthcare.repo.HospitalBedsAvailabilityRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/beds-availability")
public class HospitalBedsAvailabilityController {
    private final HospitalBedsAvailabilityRepository availabilityRepository;

    @Autowired
    public HospitalBedsAvailabilityController(HospitalBedsAvailabilityRepository availabilityRepository) {
        this.availabilityRepository = availabilityRepository;
    }

    @GetMapping("/all")
    public List<HospitalBedsAvailability> getAllBedsAvailability() {
        return availabilityRepository.findAll();
    }

    @GetMapping("/{serialNum}")
    public ResponseEntity<HospitalBedsAvailability> getBedsAvailabilityBySerialNumber(@PathVariable Long serialNum) {
        Optional<HospitalBedsAvailability> availabilityOptional = availabilityRepository.findById(serialNum);
        return availabilityOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<HospitalBedsAvailability> createBedsAvailability(@RequestBody HospitalBedsAvailability availability) {
        HospitalBedsAvailability savedAvailability = availabilityRepository.save(availability);
        return ResponseEntity.ok(savedAvailability);
    }

    @PutMapping("update/{serialNum}")
    public ResponseEntity<HospitalBedsAvailability> updateBedsAvailability(@PathVariable Long serialNum, @RequestBody HospitalBedsAvailability availability) {
        Optional<HospitalBedsAvailability> availabilityOptional = availabilityRepository.findById(serialNum);
        if (availabilityOptional.isPresent()) {
            HospitalBedsAvailability existingAvailability = availabilityOptional.get();
            existingAvailability.setHRegularBedsAvail(availability.getHRegularBedsAvail());
            existingAvailability.setHIcuBedsAvail(availability.getHIcuBedsAvail());
            // Set other properties as needed
            HospitalBedsAvailability updatedAvailability = availabilityRepository.save(existingAvailability);
            return ResponseEntity.ok(updatedAvailability);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{serialNum}")
    public ResponseEntity<Void> deleteBedsAvailability(@PathVariable Long serialNum) {
        availabilityRepository.deleteById(serialNum);
        return ResponseEntity.noContent().build();
    }
}
