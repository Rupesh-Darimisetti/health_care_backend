package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;
import tech.hospital.healthcare.enums.daysEnum;
import tech.hospital.healthcare.enums.genderEnum;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

//@ToString
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "doctor_details")
public class DoctorDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "doctor_id", nullable = false)
    private Long doctorId;

    @Column(name = "h_id", nullable = false)
    private Long hId;

    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30, nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 30, nullable = false)
    private genderEnum gender;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "specialization", length = 50, nullable = false)
    private String specialization;

    @Column(name = "contact_number", nullable = false)
    private Long contactNumber;

    @Column(name = "email_address", length = 50, nullable = false)
    private String emailAddress;

    @Column(name = "years_of_experience", nullable = false)
    private Integer yearsOfExperience;

    @Column(name = "languages_known", length = 50, nullable = false)
    private List<String> languagesKnown;

    @Column(name = "consultation_hours", length = 30, nullable = false)
    private String consultationHours;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_days", length = 30, nullable = false)
    private List<daysEnum> availabilityDays;

    // Constructors, getters, setters, and other methods
}
