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
public class DoctorDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="doctor_id",nullable = false,updatable = false, columnDefinition = "numeric(8)")
    private  Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="h_id",referencedColumnName = "h_id")
    private HospitalAccount hospitalAccount;

    @Column(nullable = false,updatable = false)
    private String doctorCode;

    @Column(name = "first_name",nullable = false, length = 30)
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 30)
    private String lastName;

    // setting the type of enum as string for the db
    @Enumerated(EnumType.STRING)
    @Column(name = "gender",columnDefinition="varchar(30)",nullable = false)
    private genderEnum gender;

    @Column(name = "age",nullable = false,length = 8)
    private Long age;

    @Column(name = "specialization",nullable = false,length = 50)
    private List<String> specialization =new ArrayList<>();

    @Column(name = "contact_number",nullable = false,length = 10)
    private String contactNumber ;

    @Column(name = "email_address",nullable = false,length = 50)
    private String emailAddress  ;

    @Column(name = "years_of_experience",nullable = false,length = 4)
    private Long yearsOfExperience ;

    @Column(name = "languages_known",nullable = false,length = 50)
    private List<String> languagesKnown = new ArrayList<>()  ;

    @Column(name = "consultation_hours",nullable = false,length = 30)
    private Time consultationHours;

    @Enumerated(EnumType.STRING)
    @Column(name = "availability_days",nullable = false, length=30,columnDefinition = "VARCHAR(30)")
    private List<daysEnum> availabilityDays;
}
