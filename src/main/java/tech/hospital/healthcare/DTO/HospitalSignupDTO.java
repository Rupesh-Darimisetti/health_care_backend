package tech.hospital.healthcare.DTO;

import lombok.Data;

@Data
public class HospitalSignupDTO {
    private Long id;
    private Long hId;
    private Long hZipCode;
    private Long hContactNumber;
    private String hCity;
    private String hName;
    private String hEmail;
    private String hState;
    private String hStreet;
    private String hPassword;

}
