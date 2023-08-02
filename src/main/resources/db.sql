CREATE TABLE IF NOT EXISTS public.general_public_user (
 	user_id varchar(25) NOT NULL,
 	password varchar(25) NOT NULL,
 	email_id varchar(50) NOT NULL,
 	last_name varchar(25) NOT NULL,
 	middle_name varchar(25)  NULL,
 	first_name varchar(25) NOT NULL,
 	contact_number numeric(12) NOT NULL,
 	street_name varchar(25) NULL,
 	city varchar(25) NULL,
 	zip_code numeric(8) NUll,
 	state varchar(25) Null,
 	emergency_contact_name varchar(25) NUll,
 	emergency_contact_number numeric(12) NUll,
 	user_created_date timestamp NULL,
 	CONSTRAINT general_public_user_pk PRIMARY KEY (user_id)
 	);

 CREATE TABLE IF NOT EXISTS public.hospital_account (
      h_id numeric(8) NOT NULL,
      h_password varchar(25) NOT NULL,
      h_name varchar(30) NOT NULL,
      h_street varchar(25) NOT NULL,
      h_zip_code numeric(10) NOT NULL,
      h_city varchar(25) NOT NULL,
      h_state varchar(25) NOT NULL,
      h_contact_number numeric(10) NOT NULL,
      h_email varchar(25) NOT NULL,
      h_website varchar(25) NULL,
      h_lab_facility varchar(10) NULL,
      h_insurance_acceptance varchar(25) NULL,
      h_scanning_facility varchar(25) NULL,
      CONSTRAINT hospital_account_pk PRIMARY KEY (h_id)
      );

CREATE TABLE IF NOT EXISTS public.hospital_beds (
    serial_num serial NOT NULL,
    h_id numeric(8) NOT NULL,
    h_regular_beds numeric(8) NOT NULL,
    h_icu_beds numeric(8) NOT NULL,
    h_pediatric_beds numeric(8) NOT NULL,
    h_maternity_beds numeric(8) NOT NULL,
    h_birthing_beds numeric(8) NOT NULL,
    h_orthopedic_beds numeric(8) NOT NULL,
    h_home_care_beds numeric(8) NOT NULL,
    h_emergency_beds numeric(8) NOT NULL,
    CONSTRAINT hospital_beds_pk PRIMARY KEY (serial_num),
    CONSTRAINT hospital_beds_fk FOREIGN KEY (h_id) REFERENCES hospital_account (h_id) ON DELETE CASCADE ON UPDATE CASCADE
            );

CREATE TABLE IF NOT EXISTS public.hospital_beds_availability (
     serial_num serial NOT NULL,
     h_id numeric(8) NOT NULL,
     h_regular_beds_avail numeric(8) NOT NULL,
     h_icu_beds_avail numeric(8) NOT NULL,
     h_pediatric_beds_avail numeric(8) NOT NULL,
     h_maternity_beds_avail numeric(8) NOT NULL,
     h_birthing_beds_avail numeric(8) NOT NULL,
     h_orthopedic_beds_avail numeric(8) NOT NULL,
     h_home_care_beds_avail numeric(8) NOT NULL,
     h_emergency_beds_avail numeric(8) NOT NULL,
     CONSTRAINT hospital_beds_availability_pk PRIMARY KEY (serial_num),
     CONSTRAINT hospital_beds_fk FOREIGN KEY (h_id) REFERENCES hospital_account (h_id) ON DELETE CASCADE ON UPDATE CASCADE
     );

CREATE TABLE IF NOT EXISTS public.doctor_details (
    h_id numeric(8) NOT NULL,
    doctor_id numeric(8) NOT NULL,
    first_name varchar(30) NOT NULL,
    last_name varchar(30) NOT NULL,
    gender varchar(30) NOT NULL,
    age numeric(8) NOT NULL,
    specialization varchar(50) NOT NULL,
    contact_number numeric(10) NOT NULL,
    email_address varchar(50) NOT NULL,
    years_of_experience numeric(4) NOT NULL,
    languages_known varchar(50) NOT NULL,
    consultation_hours varchar(30) NOT NULL,
    availability_days varchar(30) NOT NULL,
    CONSTRAINT doctor_details_pk PRIMARY KEY (doctor_id),
    CONSTRAINT hospital_beds_fk FOREIGN KEY (h_id) REFERENCES hospital_account (h_id) ON DELETE CASCADE ON UPDATE CASCADE
 );