package com.luxhomes.luxhomes.repositories;

import com.luxhomes.luxhomes.models.LuxUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface LuxUserRepository extends JpaRepository<LuxUser, Long> {
    Optional<LuxUser> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE LuxUser a SET a.enabled = true WHERE a.email = ?1")
    void enableLuxUser(String email);

}
