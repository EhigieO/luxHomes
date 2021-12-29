package com.luxhomes.luxhomes.home;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeRepository extends JpaRepository<Home, Long> {

    @Query("SELECT h FROM Home h WHERE h.id = ?1")
    Optional<Home> findHomeById(Long id);
}

