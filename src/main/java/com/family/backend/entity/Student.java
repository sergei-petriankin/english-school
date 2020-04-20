package com.family.backend.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Student extends AbstractEntity {

    private String firstName;
    private String middleName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String email;
    // TODO: 15.04.2020 provide few options
    private String socialNetworkLink;
    // TODO: 15.04.2020 parents
    private String additionalContact;
    private String address;
    private String whereCameFrom;
    private LocalDate dateOfFirstContact;
    private String comments;
    private String interests;
    private String methodOfPayment;
    private StudentType studentType;
    private EducationType educationType;
    private EducationLocation educationLocation;

    public enum StudentType {
        ADULT, CHILD, CORPORATE;
    }

    public enum EducationType {
        INDIVIDUAL, GROUP;
    }

    public enum EducationLocation {
        AUDITORIUM, CLIENT_SIDE;
    }

}
