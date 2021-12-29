package com.luxhomes.luxhomes.home;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
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
