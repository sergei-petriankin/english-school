package com.family.backend.entity;

import lombok.Data;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@Embeddable
public class PersonData {

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate dateOfBirth;

    private String phoneNumber;

    private String email;

    public String getFullName() {
        return String.format("%s %s %s", firstName, middleName, lastName);
    }
}
