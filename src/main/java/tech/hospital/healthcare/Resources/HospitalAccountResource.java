package tech.hospital.healthcare.Resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.HospitalAccount;
import tech.hospital.healthcare.service.HospitalAccountService;

import java.util.List;

@RestController
@RequestMapping("/hospital/account")
public class HospitalAccountResource {
    public final HospitalAccountService hospitalAccountService;
    public HospitalAccountResource(HospitalAccountService hospitalAccountService){
        this.hospitalAccountService = hospitalAccountService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<HospitalAccount>> getAllHospitalAccount(){
        List<HospitalAccount> hospitalAccount = hospitalAccountService.findAllHospitalAccount();
        return new ResponseEntity<>(hospitalAccount, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HospitalAccount> getAllGeneralPublicUserById(@PathVariable("id")Long id){
        HospitalAccount newGeneralPublicUser = hospitalAccountService.findHospitalAccountById(id);
        return new ResponseEntity<>(newGeneralPublicUser,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<HospitalAccount> addEmployee(@RequestBody HospitalAccount hospitalAccount){
        HospitalAccount newEmployee =hospitalAccountService.addHospitalAccount(hospitalAccount);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<HospitalAccount> updateEmployee(@RequestBody HospitalAccount hospitalAccount){
        HospitalAccount updateEmployee =hospitalAccountService.updateHospitalAccount(hospitalAccount);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
        hospitalAccountService.deleteHospitalAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
