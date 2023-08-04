package tech.hospital.healthcare.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.*;
import tech.hospital.healthcare.enums.daysEnum;
import tech.hospital.healthcare.enums.genderEnum;
import tech.hospital.healthcare.helper.StringListDeserializer;
import tech.hospital.healthcare.helper.StringToListConverter;

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
    private Long doctor_id;

    @ManyToOne
    @JsonBackReference //Manage back part of relationship
    @JoinColumn(name = "h_id",referencedColumnName = "h_id")
    private HospitalAccount hospitalAccount;

    @Column(name = "first_name", length = 30, nullable = false)
    private String first_name;

    @Column(name = "last_name", length = 30, nullable = false)
    private String last_name;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", length = 30, nullable = false)
    private genderEnum gender;

    @Column(name = "age", nullable = false)
    private Long age;

    @Column(name = "specialization", length = 50, nullable = false)
    private String specialization;

    @Column(name = "contact_number", nullable = false)
    private Long contact_number;

    @Column(name = "email_address", length = 50, nullable = false)
    private String email_address;

    @Column(name = "years_of_experience", nullable = false)
    private Integer years_of_experience;
    @Convert(converter = StringToListConverter.class)
    @JsonDeserialize(using = StringListDeserializer.class)
    @Column(name = "languages_known", length = 50, nullable = false)
    private List<String> languages_known = new ArrayList<>();

    @Column(name = "consultation_hours", length = 30, nullable = false)
    private String consultation_hours;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_days", length = 30, nullable = false)
    private List<daysEnum> availability_days = new ArrayList<>();

    // Constructors, getters, setters, and other methods
}
