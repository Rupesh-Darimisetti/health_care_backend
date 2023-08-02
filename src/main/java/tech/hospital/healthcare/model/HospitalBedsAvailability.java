package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_beds_availability")
public class HospitalBedsAvailability implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "serial_num",nullable = false,updatable = false,length = 8)
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="h_id",referencedColumnName = "h_id")
    private HospitalAccount hospitalAccount;
    
    @Column(name = "h_regular_beds_avail",nullable = false,length = 8)
    private String hRegularBedsAvail;
    
    @Column(name = "h_icu_beds_avail",nullable = false,length = 8)
    private String hIcuBedsAvail;

    @Column(name = "h_pediatric_beds_avail",nullable = false,length = 8)
    private String hPediatricBedsAvail;

    @Column(name = "h_maternity_beds_avail",nullable = false,length = 8)
    private String hMaternityBedsAvail;

    @Column(name = "h_birthing_beds_avail",nullable = false,length = 8)
    private String hBirthingBedsAvail;

    @Column(name = "h_orthopedic_beds_avail",nullable = false,length = 8)
    private String hOrthopedicBedsAvail;

    @Column(name = "h_home_care_beds_avail",nullable = false,length = 8)
    private String hHomeCareBedsAvail;

    @Column(name = "h_emergency_beds_avail",nullable = false,length = 8)
    private String hEmergencyBedsAvail;
}
