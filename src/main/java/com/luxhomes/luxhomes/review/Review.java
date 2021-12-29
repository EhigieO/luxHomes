package com.luxhomes.luxhomes.review;

import com.luxhomes.luxhomes.home.Grade;
import com.luxhomes.luxhomes.home.Home;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @Column (nullable = false)
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
