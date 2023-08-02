package tech.hospital.healthcare.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hospital_beds")
public class HospitalBeds implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="serial_num",updatable = false,nullable = false,length = 8)
    private Long id;
    
    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "h_id",referencedColumnName = "h_id")
    private HospitalAccount hospitalAccount;
    
    @Column(name="beds_code",nullable = false,updatable = false,length = 8)
    private String bed_code;
    
    @Column(name = "h_regular_beds",nullable = false,length = 8)
    private Long hRegularBeds;

    @Column(name = "h_icu_beds",nullable = false,length = 8)
    private Long hIcuBeds;

    @Column(name = "h_pediatric_beds",nullable = false,length = 8)
    private Long hPediatricBeds;

    @Column(name = "h_maternity_beds",nullable = false,length = 8)
    private Long hMaternityBeds;

    @Column(name = "h_birthing_beds",nullable = false,length = 8)
    private Long hBirthingBeds;

    @Column(name = "h_orthopedic_beds",nullable = false,length = 8)
    private Long hOrthopedicBeds;

    @Column(name = "h_home_care_beds",nullable = false,length = 8)
    private Long hHomeCareBeds;

    @Column(name = "h_emergency_beds",nullable = false,length = 8)
    private Long hEmergencyBeds;
}
