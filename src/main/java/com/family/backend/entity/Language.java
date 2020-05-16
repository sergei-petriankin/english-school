package com.family.backend.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Language extends AbstractEntity {
    private String languageName;
}
