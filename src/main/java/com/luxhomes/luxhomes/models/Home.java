package com.luxhomes.luxhomes.models;

import com.luxhomes.luxhomes.models.Review;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table
@Data
@Entity
@NoArgsConstructor
public class Home {
    @Id
    @SequenceGenerator(
            name="home_sequence",
            sequenceName="home_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator = "home_sequence"
    )
    private Long HomeId;
    @NotNull
    private String address;
    @OneToMany
    private List<Review> reviews = new ArrayList<>();
    private Integer numberOfBeds;
    private Boolean furnished;
    private Boolean availability;
    private Integer numberOfToilets;
    private Boolean visitorsToilet;
    private Double rentPerYear;
    private Integer squareFeet;
    private LocalDate dateOfCreation;
    @ManyToOne
    @JoinColumn(name = "lux_user_id")
    private LuxUser landlord;

    public Home(LuxUser landlord,
                String address,
                Integer numberOfBeds,
                Boolean furnished,
                Boolean availability,
                Integer numberOfToilets,
                Boolean visitorsToilet,
                Double rentPerYear,
                Integer squareFeet)
    {
        this.landlord = landlord;
        this.address = address;
        this.numberOfBeds = numberOfBeds;
        this.furnished = furnished;
        this.availability = availability;
        this.numberOfToilets = numberOfToilets;
        this.visitorsToilet = visitorsToilet;
        this.rentPerYear = rentPerYear;
        this.squareFeet = squareFeet;
    }
}
