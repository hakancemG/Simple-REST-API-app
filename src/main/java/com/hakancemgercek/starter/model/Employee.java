package com.hakancemgercek.starter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee { // Çalışan entity'si.

    private String id;

    private String firstName;

    private String lastName;
}
