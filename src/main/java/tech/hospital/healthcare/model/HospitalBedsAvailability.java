package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_beds_availability")
public class HospitalBedsAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_num", nullable = false)
    private Long serialNum;

    @Column(name = "h_id", nullable = false)
    private Long hId;

    @Column(name = "h_regular_beds_avail", nullable = false)
    private Long hRegularBedsAvail;

    @Column(name = "h_icu_beds_avail", nullable = false)
    private Long hIcuBedsAvail;

    @Column(name = "h_pediatric_beds_avail", nullable = false)
    private Long hPediatricBedsAvail;

    @Column(name = "h_maternity_beds_avail", nullable = false)
    private Long hMaternityBedsAvail;

    @Column(name = "h_birthing_beds_avail", nullable = false)
    private Long hBirthingBedsAvail;

    @Column(name = "h_orthopedic_beds_avail", nullable = false)
    private Long hOrthopedicBedsAvail;

    @Column(name = "h_home_care_beds_avail", nullable = false)
    private Long hHomeCareBedsAvail;

    @Column(name = "h_emergency_beds_avail", nullable = false)
    private Long hEmergencyBedsAvail;

    // Constructors, getters, setters, and other methods
}
