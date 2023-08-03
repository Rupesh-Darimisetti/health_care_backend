package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.DoctorDetails;
import tech.hospital.healthcare.repo.DoctorDetailsRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorDetailsController {
    private final DoctorDetailsRepository doctorRepository;

    @Autowired
    public DoctorDetailsController(DoctorDetailsRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/all")
    public List<DoctorDetails> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<DoctorDetails> getDoctorById(@PathVariable Long doctorId) {
        Optional<DoctorDetails> doctorOptional = doctorRepository.findById(doctorId);
        return doctorOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<DoctorDetails> createDoctor(@RequestBody DoctorDetails doctor) {
        DoctorDetails savedDoctor = doctorRepository.save(doctor);
        return ResponseEntity.ok(savedDoctor);
    }

    @PutMapping("update/{doctorId}")
    public ResponseEntity<DoctorDetails> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDetails doctor) {
        Optional<DoctorDetails> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()) {
            DoctorDetails existingDoctor = doctorOptional.get();
            existingDoctor.setFirstName(doctor.getFirstName());
            existingDoctor.setLastName(doctor.getLastName());
            // Set other properties as needed
            DoctorDetails updatedDoctor = doctorRepository.save(existingDoctor);
            return ResponseEntity.ok(updatedDoctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{doctorId}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long doctorId) {
        doctorRepository.deleteById(doctorId);
        return ResponseEntity.noContent().build();
    }
}
