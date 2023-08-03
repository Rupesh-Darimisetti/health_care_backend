package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_account")
public class HospitalAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "h_id", nullable = false)
    private Long hId;

    @Column(name = "h_password", length = 25, nullable = false)
    private String hPassword;

    @Column(name = "h_name", length = 30, nullable = false)
    private String hName;

    @Column(name = "h_street", length = 25, nullable = false)
    private String hStreet;

    @Column(name = "h_zip_code", nullable = false)
    private Long hZipCode;

    @Column(name = "h_city", length = 25, nullable = false)
    private String hCity;

    @Column(name = "h_state", length = 25, nullable = false)
    private String hState;

    @Column(name = "h_contact_number", nullable = false)
    private Long hContactNumber;

    @Column(name = "h_email", length = 25, nullable = false)
    private String hEmail;

    @Column(name = "h_website", length = 25)
    private String hWebsite;

    @Column(name = "h_lab_facility", length = 10)
    private String hLabFacility;

    @Column(name = "h_insurance_acceptance", length = 25)
    private String hInsuranceAcceptance;

    @Column(name = "h_scanning_facility", length = 25)
    private String hScanningFacility;

    // Constructors, getters, setters, and other methods
}