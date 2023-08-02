package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_account")
public class HospitalAccount  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="h_id",nullable = false,updatable = false,length = 8)
    private Long id;

    @Column(name = "h_password",nullable = false,length = 25)
    private String hPassword;

    @Column(name = "h_name",nullable = false,length = 30)
    private String hName;

    @Column(name = "h_street",nullable = false,length = 25)
    private String hStreet ;

    @Column(name = "h_zip_code",nullable = false,length = 10)
    private String hZipCode;

    @Column(name = "h_city",nullable = false,length = 25)
    private String hCity ;

    @Column(name = "h_state",nullable = false,length = 25)
    private String hState ;

    @Column(name = "h_contact_number",nullable = false,length = 10)
    private String hContactNumber;

    @Column(name = "h_email",nullable = false,length = 25)
    private String hEmail;

    @Column(name = "h_website",length = 25)
    private String hWebsite;

    @Column(name = "h_lab_facility",length = 10)
    private String hLabFacility;

    @Column(name = "h_insurance_acceptance",length = 25)
    private String hInsuranceAcceptance;

    @Column(name = "h_scanning_facility",length = 25)
    private String hScanningFacility;

    @Column(nullable = false,updatable = false)
    private String hCode;
}
