package tech.hospital.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.model.HospitalBeds;
import tech.hospital.healthcare.repo.HospitalBedsRepository;

@Service
public class HospitalBedsService {
    private final HospitalBedsRepository hospitalBedsRepository;

    @Autowired
    public HospitalBedsService(HospitalBedsRepository hospitalBedsRepository) {
        this.hospitalBedsRepository = hospitalBedsRepository;
    }

    // Add methods for business logic related to HospitalBeds entity

    public HospitalBeds saveHospitalBeds(HospitalBeds hospitalBeds) {
        return hospitalBedsRepository.save(hospitalBeds);
    }

    public HospitalBeds getHospitalBedsBySerialNum(Long serialNum) {
        return hospitalBedsRepository.findById(serialNum).orElse(null);
    }

    public void deleteHospitalBeds(Long serialNum) {
        hospitalBedsRepository.deleteById(serialNum);
    }

    // Add more methods as needed
//    public List<HospitalBeds> findAllHospitalBeds(){
//        return hospitalBedsRepo.findAll();
//    }
//
//    public HospitalBeds updateHospitalBeds(HospitalBeds hospitalBeds){
//        return hospitalBedsRepo.save(hospitalBeds);
//    }
//
//    public HospitalBeds findHospitalBedsById(Long serial_num){
//        return hospitalBedsRepo.findHospitalBedsById(serial_num)
//                .orElseThrow(()-> new UserNotFoundException("Hospital by id " + serial_num + " was not found."));
//    }
//
//    public void deleteHospitalBeds(Long serial_num){
//        hospitalBedsRepo.deleteHospitalBedsById(serial_num);
//    }
}
