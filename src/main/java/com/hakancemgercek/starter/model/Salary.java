package com.hakancemgercek.starter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Salary { // Maaş entity'si.
    private String id;
    private Long salaryAmount;
}
