package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.DoctorDetails;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.repo.DoctorDetailsRepository;
import tech.hospital.healthcare.repo.HospitalAccountRepository;
import tech.hospital.healthcare.service.DoctorDetailsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorDetailsController {
    private final DoctorDetailsRepository doctorRepository;
    @Autowired
    private DoctorDetailsService doctorDetailsService;
private final HospitalAccountRepository hospitalAccountRepository;
    @Autowired
    public DoctorDetailsController(DoctorDetailsRepository doctorRepository, HospitalAccountRepository hospitalAccountRepository) {
        this.doctorRepository = doctorRepository;
        this.hospitalAccountRepository = hospitalAccountRepository;
    }

    @GetMapping("/all")
    public List<DoctorDetails> getAllDoctors() {
        var doctorsWithoutRelation = getDoctorsWithoutRelation();
        var doctorsWithRelation = getDoctorsWithRelation();
        doctorRepository.saveAll(doctorsWithRelation);
        doctorRepository.saveAll(doctorsWithoutRelation);
        return doctorRepository.findAll();
    }
    @GetMapping("/without-relation")
    public List<DoctorDetails> getDoctorsWithoutRelation() {
        // Fetch doctors with the relation using the repository
        return doctorRepository.findAllByHospitalAccountIsNull();
    }
    @GetMapping("/with-relation")
    public List<DoctorDetails> getDoctorsWithRelation() {
        // Fetch doctors with the relation using the repository
        return doctorRepository.findAllByHospitalAccountIsNotNull();
    }
    @GetMapping("/{hospitalId}")
    public ResponseEntity<List<DoctorDetails>> getDoctorById(@PathVariable Long hospitalId) {
        List<DoctorDetails> doctorDetails = doctorDetailsService.getDoctorDetailsByHospitalId(hospitalId);
        return !doctorDetails.isEmpty() ? ResponseEntity.ok(doctorDetails) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<DoctorDetails> createDoctor(@RequestBody DoctorDetails doctor) {
//        HospitalAccount savedHospital = hospitalAccountRepository.save(doctor.getHospitalAccount());
        DoctorDetails savedDoctor = doctorRepository.save(doctor);
//        ResponseEntity.ok(savedHospital);
        return ResponseEntity.ok(savedDoctor);
    }

    @PutMapping("update/{doctorId}")
    public ResponseEntity<DoctorDetails> updateDoctor(@PathVariable Long doctorId, @RequestBody DoctorDetails doctor) {
        Optional<DoctorDetails> doctorOptional = doctorRepository.findById(doctorId);
        if (doctorOptional.isPresent()) {
            DoctorDetails existingDoctor = doctorOptional.get();
            existingDoctor.setDoctor_id(existingDoctor.getDoctor_id());
            existingDoctor.setHospitalAccount(doctor.getHospitalAccount());
            existingDoctor.setHospitalAccount(doctor.getHospitalAccount());
            existingDoctor.setFirst_name(doctor.getFirst_name());
            existingDoctor.setLast_name(doctor.getLast_name());
            existingDoctor.setGender(doctor.getGender());
            existingDoctor.setAge(doctor.getAge());
            existingDoctor.setSpecialization(doctor.getSpecialization());
            existingDoctor.setContact_number(doctor.getContact_number());
            existingDoctor.setEmail_address(doctor.getEmail_address());
            existingDoctor.setYears_of_experience(doctor.getYears_of_experience());
            existingDoctor.setLanguages_known(doctor.getLanguages_known());
            existingDoctor.setConsultation_hours(doctor.getConsultation_hours());
            existingDoctor.setAvailability_days(doctor.getAvailability_days());
// Set other properties as needed
            DoctorDetails updatedDoctor = doctorRepository.save(existingDoctor);
            return ResponseEntity.ok(updatedDoctor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Long doctorId) {
        List<DoctorDetails> doctorsWithRelation = getDoctorsWithRelation();
        getDoctorsWithRelation().stream()
                .filter(hospitalAccount -> hospitalAccount.getHospitalAccount().getH_id().equals(doctorId))
                .findFirst()
                .orElse(null);

        getDoctorsWithoutRelation().stream()
                .filter(hospitalAccount -> hospitalAccount.getDoctor_id().equals(doctorId))
                .findFirst()
                .orElse(null);

        List<DoctorDetails> doctorsWithoutRelation = getDoctorsWithoutRelation();
        doctorsWithoutRelation.stream().filter((data)-> {
            if( data.getDoctor_id().equals(doctorId)) {
                doctorRepository.deleteById(doctorId);
            }
            return false;
        });
            doctorRepository.deleteById(doctorId);
        return ResponseEntity.noContent().build();
    }
}