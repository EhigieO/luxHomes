package com.luxhomes.luxhomes.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String reviewerName;
    @Column(nullable = false)
    private String text;
    @UpdateTimestamp
    private LocalDateTime createdAt;
    private Grade grade;
    @ManyToOne
    private Home home;

}
