package com.family.backend.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IdNameLookup {
    Long id;
    String name;

    public static IdNameLookup of(Long id, String name) {
        return new IdNameLookup(id, name);
    }
}
