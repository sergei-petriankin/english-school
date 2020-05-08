package com.family.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class IdNameLookup {
    Long id;
    String name;

    public static IdNameLookup of(Long id, String name) {
        return new IdNameLookup(id, name);
    }
}
