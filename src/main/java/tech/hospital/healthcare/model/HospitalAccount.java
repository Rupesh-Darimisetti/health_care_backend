package tech.hospital.healthcare.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import javax.print.Doc;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_account")
public class HospitalAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "h_id", columnDefinition = "numeric(8) ", nullable=false, unique = true)
    private Integer h_id;

    @Column(name = "h_password",columnDefinition = "varchar(25) ", nullable=false)
    private String h_password;

    @Column(name = "h_name",columnDefinition = "varchar(30) ", nullable=false)
    private String h_name;

    @Column(name = "h_street", columnDefinition = "varchar(25) ", nullable=false)
    private String h_street;

    @Column(name = "h_zip_code",columnDefinition = "numeric(10) ", nullable=false)
    private Integer h_zip_code;

    @Column(name = "h_city",columnDefinition = "varchar(25) ", nullable=false)
    private String h_city;

    @Column(name = "h_state", columnDefinition = "varchar(25) ", nullable=false)
    private String h_state;

    @Column(name = "h_contact_number",columnDefinition = "numeric(10) ", nullable=false)
    private Long h_contact_number;

    @Column(name = "h_email", columnDefinition = "varchar(25) ", nullable=false)
    private String h_email;

    @Column(name = "h_website", columnDefinition = "varchar(25)")
    private String h_website;

    @Column(name = "h_lab_facility", columnDefinition = "varchar(10)")
    private String hLabFacility;

    @Column(name = "h_insurance_acceptance",columnDefinition = "varchar(25)")
    private String hInsuranceAcceptance;

    @Column(name = "h_scanning_facility", columnDefinition = "varchar(25)")
    private String hScanningFacility;

    @OneToMany(mappedBy = "hospitalAccount",cascade = CascadeType.ALL)
    @JsonManagedReference // Manage forward part of the relationship
     List<DoctorDetails> doctorDetailsList;
    // Constructors, getters, setters, and other methods
}