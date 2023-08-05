package tech.hospital.healthcare.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serial_num", nullable = false)
    private Long serial_num;

    @OneToOne
    @JsonBackReference //Manage back part of relationship
    @JoinColumn(name = "h_id",referencedColumnName = "h_id")
    private HospitalAccount hospitalAccount;

    @Column(name = "h_regular_beds", nullable = false)
    private Long h_regular_beds;

    @Column(name = "h_icu_beds", nullable = false)
    private Long h_icu_beds;

    @Column(name = "h_pediatric_beds", nullable = false)
    private Long h_pediatric_beds;

    @Column(name = "h_maternity_beds", nullable = false)
    private Long h_maternity_beds;

    @Column(name = "h_birthing_beds", nullable = false)
    private Long h_birthing_beds;

    @Column(name = "h_orthopedic_beds", nullable = false)
    private Long h_orthopedic_beds;

    @Column(name = "h_home_care_beds", nullable = false)
    private Long h_home_care_beds;

    @Column(name = "h_emergency_beds", nullable = false)
    private Long h_emergency_beds;

    // Constructors, getters, setters, and other methods
}
