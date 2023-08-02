package tech.hospital.healthcare.Resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.DoctorDetails;
import tech.hospital.healthcare.service.DoctorDetailsService;

import java.util.List;
@RestController
@RequestMapping("/hospital/doctor")
public class DoctorDetailsResource {
    private final DoctorDetailsService doctorDetailsService;


    public DoctorDetailsResource(DoctorDetailsService doctorDetailsService) {
        this.doctorDetailsService = doctorDetailsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDetails>> getAllDoctorDetails(){
        List<DoctorDetails> doctorDetails = doctorDetailsService.findAllDoctorDetails();
        return new ResponseEntity<>(doctorDetails, HttpStatus.OK);
    }

    @GetMapping("/find/{doctor_id}")
    public ResponseEntity<DoctorDetails> getAllDoctorDetailsById(@PathVariable("doctor_id")Long doctorId){
        DoctorDetails doctorDetail = doctorDetailsService.findDoctorDetailsById(doctorId);
        return new ResponseEntity<>(doctorDetail,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DoctorDetails> addDoctorDetails(@RequestBody DoctorDetails doctorDetails){
        DoctorDetails newDoctorDetails = doctorDetailsService.addDoctor(doctorDetails);
        return new ResponseEntity<>(newDoctorDetails,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<DoctorDetails> updateDoctorDetails(@RequestBody DoctorDetails doctorDetails){
        DoctorDetails updateDoctorDetails = doctorDetailsService.updateDoctorDetails(doctorDetails);
        return new ResponseEntity<>(updateDoctorDetails,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{doctor_id}")
    public ResponseEntity<?> deleteDoctorDetails(@PathVariable("doctor_id")Long id){
        doctorDetailsService.deleteDoctorDetails(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

