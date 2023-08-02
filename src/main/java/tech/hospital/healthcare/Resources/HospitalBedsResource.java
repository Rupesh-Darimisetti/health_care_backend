package tech.hospital.healthcare.Resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalBeds;
import tech.hospital.healthcare.service.HospitalBedsService;

import java.util.List;

@RestController
@RequestMapping("/hospital/beds")
public class HospitalBedsResource {
    public final HospitalBedsService hospitalBedsService;
    public HospitalBedsResource(HospitalBedsService hospitalBedsService){
        this.hospitalBedsService = hospitalBedsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<HospitalBeds>> getAllHospitalBeds(){
        List<HospitalBeds> hospitalBeds = hospitalBedsService.findAllHospitalBeds();
        return new ResponseEntity<>(hospitalBeds, HttpStatus.OK);
    }

    @GetMapping("/find/{serial_num}")
    public ResponseEntity<HospitalBeds> getAllGeneralPublicUserById(@PathVariable("serial_num")Long serial_num){
        HospitalBeds newGeneralPublicUser = hospitalBedsService.findHospitalBedsById(serial_num);
        return new ResponseEntity<>(newGeneralPublicUser,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<HospitalBeds> addEmployee(@RequestBody HospitalBeds hospitalBeds){
        HospitalBeds newEmployee =hospitalBedsService.addHospitalBeds(hospitalBeds);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<HospitalBeds> updateEmployee(@RequestBody HospitalBeds hospitalBeds){
        HospitalBeds updateEmployee =hospitalBedsService.updateHospitalBeds(hospitalBeds);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{serial_num}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("serial_num")Long serial_num){
        hospitalBedsService.deleteHospitalBeds(serial_num);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
