package com.family.backend.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class IdNameLookup {
    Long id;
    String name;

    public static IdNameLookup of(Long id, String name) {
        return new IdNameLookup(id, name);
    }

    public static IdNameLookup of(Long id) {
        return new IdNameLookup(id, null);
    }
}
