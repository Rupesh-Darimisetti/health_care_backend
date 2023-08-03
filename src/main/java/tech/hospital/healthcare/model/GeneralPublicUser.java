package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.security.Timestamp;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_public_user")
public class GeneralPublicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

    @Column(name = "password", length = 25, nullable = false)
    private String password;

    @Column(name = "email_id", length = 50, nullable = false)
    private String emailId;

    @Column(name = "last_name", length = 25, nullable = false)
    private String lastName;

    @Column(name = "middle_name", length = 25)
    private String middleName;

    @Column(name = "first_name", length = 25, nullable = false)
    private String firstName;

    @Column(name = "contact_number", nullable = false)
    private Long contactNumber;

    @Column(name = "street_name", length = 25)
    private String streetName;

    @Column(name = "city", length = 25)
    private String city;

    @Column(name = "zip_code")
    private Long zipCode;

    @Column(name = "state", length = 25)
    private String state;

    @Column(name = "emergency_contact_name", length = 25)
    private String emergencyContactName;

    @Column(name = "emergency_contact_number")
    private Long emergencyContactNumber;

    @Column(name = "user_created_date")
    private Timestamp userCreatedDate;

    // Constructors, getters, setters, and other methods
}