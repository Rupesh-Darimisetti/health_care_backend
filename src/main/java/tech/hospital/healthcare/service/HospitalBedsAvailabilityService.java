package tech.hospital.healthcare.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hospital.healthcare.model.HospitalBedsAvailability;
import tech.hospital.healthcare.repo.HospitalBedsAvailabilityRepository;

@Service
public class HospitalBedsAvailabilityService {
    private final HospitalBedsAvailabilityRepository hospitalBedsAvailabilityRepository;

    @Autowired
    public HospitalBedsAvailabilityService(HospitalBedsAvailabilityRepository hospitalBedsAvailabilityRepository) {
        this.hospitalBedsAvailabilityRepository = hospitalBedsAvailabilityRepository;
    }

    // Add methods for business logic related to HospitalBedsAvailability entity

    public HospitalBedsAvailability saveHospitalBedsAvailability(HospitalBedsAvailability bedsAvailability) {
        return hospitalBedsAvailabilityRepository.save(bedsAvailability);
    }

    public HospitalBedsAvailability getHospitalBedsAvailabilityBySerialNum(Long serialNum) {
        return hospitalBedsAvailabilityRepository.findById(serialNum).orElse(null);
    }

    public void deleteHospitalBedsAvailability(Long serialNum) {
        hospitalBedsAvailabilityRepository.deleteById(serialNum);
    }

    // Add more methods as needed
}
