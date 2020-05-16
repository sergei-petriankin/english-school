package com.family.backend.entity;

import com.family.backend.enums.EducationLocation;
import com.family.backend.enums.EducationType;
import com.family.backend.enums.StudentStatus;
import com.family.backend.enums.StudentType;
import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Data
@Entity
public class Student extends AbstractEntity {

    @Embedded
    private PersonData personData;

    @OneToMany
    private Set<SocialNetworkLink> socialNetworkLinks;

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

    public String getFullName() {
        return personData.getFullName();
    }
}
