package tech.hospital.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.model.DoctorDetails;
import tech.hospital.healthcare.repo.DoctorDetailsRepository;

@Service
public class DoctorDetailsService {
    private final DoctorDetailsRepository doctorDetailsRepository;

    @Autowired
    public DoctorDetailsService(DoctorDetailsRepository doctorDetailsRepository) {
        this.doctorDetailsRepository = doctorDetailsRepository;
    }

    // Add methods for business logic related to DoctorDetails entity

    public DoctorDetails saveDoctorDetails(DoctorDetails doctorDetails) {
        return doctorDetailsRepository.save(doctorDetails);
    }

    public DoctorDetails getDoctorDetailsById(Long doctorId) {
        return doctorDetailsRepository.findById(doctorId).orElse(null);
    }

    public void deleteDoctorDetails(Long doctorId) {
        doctorDetailsRepository.deleteById(doctorId);
    }

    // Add more methods as needed

//    public List<DoctorDetails> findAllDoctorDetails(){
//        return doctorDetailsRepo.findAll();
//    }
//
//    public DoctorDetails updateDoctorDetails(DoctorDetails doctorDetails){
//        return doctorDetailsRepo.save(doctorDetails);
//    }
//    public DoctorDetails findDoctorDetailsById(Long  doctor_id){
//        return doctorDetailsRepo.findDoctorDetailsById(doctor_id)
//                .orElseThrow(()-> new UserNotFoundException("Doctor by id " + doctor_id+" was not found"));
//    }
//
//    public void deleteDoctorDetails(Long doctor_id){
//        doctorDetailsRepo.deleteDoctorDetailsById(doctor_id);
//    }
}
