package com.luxhomes.luxhomes.dtos.addHome;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHomeDto {
    private String address;
    private Integer numberOfBeds;
    private Boolean furnished;
    private Integer numberOfToilets;
    private Boolean visitorsToilet;
    private Double rentPerYear;
    private Integer squareFeet;
    private String Email;
}
