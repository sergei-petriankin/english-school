package com.family.backend.entity;

import com.family.backend.enums.EducationLocation;
import com.family.backend.enums.EducationType;
import com.family.backend.enums.StudentStatus;
import com.family.backend.enums.StudentType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

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

    @OneToMany
    private Set<SocialNetworkLink> socialNetworkLinks;
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
    private StudentStatus status;

    @ManyToMany
    private Set<Group> groups;
}
