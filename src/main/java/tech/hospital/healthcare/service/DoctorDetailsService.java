package tech.hospital.healthcare.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.exception.UserNotFoundException;
import tech.hospital.healthcare.model.DoctorDetails;
import tech.hospital.healthcare.repo.DoctorDetailsRepo;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DoctorDetailsService {
    private final DoctorDetailsRepo doctorDetailsRepo;

    @Autowired
    public DoctorDetailsService(DoctorDetailsRepo doctorDetailsRepo){
        this.doctorDetailsRepo = doctorDetailsRepo;
    }

    public DoctorDetails addDoctor(DoctorDetails doctorDetails){
        doctorDetails.setDoctorCode(UUID.randomUUID().toString());
        return doctorDetailsRepo.save(doctorDetails);
    }

    public List<DoctorDetails> findAllDoctorDetails(){
        return doctorDetailsRepo.findAll();
    }

    public DoctorDetails updateDoctorDetails(DoctorDetails doctorDetails){
        return doctorDetailsRepo.save(doctorDetails);
    }
    public DoctorDetails findDoctorDetailsById(Long  doctor_id){
        return doctorDetailsRepo.findDoctorDetailsById(doctor_id)
                .orElseThrow(()-> new UserNotFoundException("Doctor by id " + doctor_id+" was not found"));
    }

    public void deleteDoctorDetails(Long doctor_id){
        doctorDetailsRepo.deleteDoctorDetailsById(doctor_id);
    }
}
