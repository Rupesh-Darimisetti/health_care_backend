package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "general_public_user")
public class GeneralPublicUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",nullable = false,updatable = false,length = 25)
    private long id;

    @Column(name="user_code",nullable = false,updatable = false)
    private String userCode;

    @Column(name = "password",nullable = false,length = 25)
    private String password;

    @Column(name = "email_id",nullable = false,length = 50)
    private String emailId;

    @Column(name = "first_name",nullable = false,length = 25)
    private String firstName;

    @Column(name = "middle_name",nullable = false,length = 25)
    private String middleName;

    @Column(name = "last_name",nullable = false,length = 25)
    private String last_name;

    @Column(name = "contact_number",nullable = false,length = 12)
    private String contactNumber;

    @Column(name = "street_name",length = 25)
    private String streetName;

    @Column(name = "city",length = 25)
    private String city;

    @Column(name = "state",length = 25)
    private String state ;

    @Column(name = "zip_code",length = 8)
    private String zipCode;

    @CreationTimestamp
    @Column(name = "user_created_date")
    private LocalDateTime userCreatedDate;

    @Column(name = "emergency_contact_name",length = 25)
    private String emergencyContactName;

    @Column(name = "emergency_contact_number",length = 12)
    private String emergencyContactNumber;
}