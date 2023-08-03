package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_beds")
public class HospitalBeds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_num", nullable = false)
    private Long serialNum;

    @Column(name = "h_id", nullable = false)
    private Long hId;

    @Column(name = "h_regular_beds", nullable = false)
    private Long hRegularBeds;

    @Column(name = "h_icu_beds", nullable = false)
    private Long hIcuBeds;

    @Column(name = "h_pediatric_beds", nullable = false)
    private Long hPediatricBeds;

    @Column(name = "h_maternity_beds", nullable = false)
    private Long hMaternityBeds;

    @Column(name = "h_birthing_beds", nullable = false)
    private Long hBirthingBeds;

    @Column(name = "h_orthopedic_beds", nullable = false)
    private Long hOrthopedicBeds;

    @Column(name = "h_home_care_beds", nullable = false)
    private Long hHomeCareBeds;

    @Column(name = "h_emergency_beds", nullable = false)
    private Long hEmergencyBeds;

    // Constructors, getters, setters, and other methods
}
