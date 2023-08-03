package tech.hospital.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.hospital.healthcare.model.GeneralPublicUser;
import tech.hospital.healthcare.repo.GeneralPublicUserRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class GeneralPublicUserController {
    private final GeneralPublicUserRepository userRepository;

    @Autowired
    public GeneralPublicUserController(GeneralPublicUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/all")
    public List<GeneralPublicUser> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<GeneralPublicUser> getUserById(@PathVariable Long id) {
        Optional<GeneralPublicUser> userOptional = userRepository.findById(id);
        return userOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<GeneralPublicUser> createUser(@RequestBody GeneralPublicUser user) {
        GeneralPublicUser savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("update/{user_id}")
    public ResponseEntity<GeneralPublicUser> updateUser(@PathVariable Long id, @RequestBody GeneralPublicUser user) {
        Optional<GeneralPublicUser> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            GeneralPublicUser existingUser = userOptional.get();
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            // Set other properties as needed
            GeneralPublicUser updatedUser = userRepository.save(existingUser);
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{user_id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
