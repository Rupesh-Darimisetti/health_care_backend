package tech.hospital.healthcare.Resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.GeneralPublicUser;
import tech.hospital.healthcare.service.GeneralPublicUserService;

import java.util.List;

@RestController
@RequestMapping("/customer/user")
public class GeneralPublicUserResource {

    public final GeneralPublicUserService generalPublicUserService;

    public GeneralPublicUserResource(GeneralPublicUserService generalPublicUserService){
        this.generalPublicUserService = generalPublicUserService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<GeneralPublicUser>> getAllGeneralPublicUser(){
        List<GeneralPublicUser> generalPublicUsers = generalPublicUserService.findAllGeneralPublicUsers();
        return  new ResponseEntity<>(generalPublicUsers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<GeneralPublicUser> getAllGeneralPublicUserById(@PathVariable("id")Long id){
        GeneralPublicUser newGeneralPublicUser = generalPublicUserService.findGeneralPublicUserById(id);
        return new ResponseEntity<>(newGeneralPublicUser,HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<GeneralPublicUser> addEmployee(@RequestBody GeneralPublicUser employee){
        GeneralPublicUser newEmployee =generalPublicUserService.addGeneralPublicUser(employee);
        return new ResponseEntity<>(newEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<GeneralPublicUser> updateEmployee(@RequestBody GeneralPublicUser employee){
        GeneralPublicUser updateEmployee =generalPublicUserService.updateGeneralPublicUser(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
        generalPublicUserService.deleteGeneralPublicUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
