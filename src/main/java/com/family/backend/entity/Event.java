package com.family.backend.entity;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Event extends AbstractEntity {

    private String name;
    private LocalDate eventData;
}
