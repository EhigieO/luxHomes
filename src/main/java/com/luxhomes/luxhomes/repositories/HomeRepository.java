package com.luxhomes.luxhomes.repositories;

import com.luxhomes.luxhomes.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    @Query("SELECT h FROM Home h WHERE h.HomeId = ?1")
    default Optional<Home> findHomeById(Long homeId) {
        return Optional.empty();
    }
}

