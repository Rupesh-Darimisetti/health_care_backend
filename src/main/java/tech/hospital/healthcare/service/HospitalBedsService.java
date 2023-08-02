package tech.hospital.healthcare.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.exception.UserNotFoundException;
import tech.hospital.healthcare.model.HospitalBeds;
import tech.hospital.healthcare.repo.HospitalBedsRepo;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class HospitalBedsService {

    private final HospitalBedsRepo hospitalBedsRepo;
    @Autowired
    public HospitalBedsService(HospitalBedsRepo hospitalBedsRepo) {
        this.hospitalBedsRepo = hospitalBedsRepo;
    }
    public HospitalBeds addHospitalBeds(HospitalBeds hospitalBeds){
        hospitalBeds.setBed_code(UUID.randomUUID().toString());
        return hospitalBedsRepo.save(hospitalBeds);
    }

    public List<HospitalBeds> findAllHospitalBeds(){
        return hospitalBedsRepo.findAll();
    }

    public HospitalBeds updateHospitalBeds(HospitalBeds hospitalBeds){
        return hospitalBedsRepo.save(hospitalBeds);
    }

    public HospitalBeds findHospitalBedsById(Long serial_num){
        return hospitalBedsRepo.findHospitalBedsById(serial_num)
                .orElseThrow(()-> new UserNotFoundException("Hospital by id " + serial_num + " was not found."));
    }

    public void deleteHospitalBeds(Long serial_num){
        hospitalBedsRepo.deleteHospitalBedsById(serial_num);
    }
}
