package com.luxhomes.luxhomes.luxUser;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static com.luxhomes.luxhomes.luxUser.LuxUserRole.LANDLORD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LuxUserRepositoryTest {

    @Autowired
    LuxUserRepository luxUserRepository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void userCanBeCreated(){
        LuxUser luxUser = LuxUser.builder()
                .firstName("Sandra")
                .lastName("Oluwatobi")
                .email("Sandie@gmail.com")
                .phoneNumber("0709545210")
                .password("sunny12")
                .luxUserRole(LANDLORD)
                .build();

        log.info("Before saving ->{}", luxUser);
        assertThat(luxUser.getId()).isNull();
        luxUserRepository.save(luxUser);
        log.info("After saving -> {}", luxUser);
        assertThat(luxUser.getId()).isNotNull();
    }

    @Test
            void testUserIsCreatedUniquely(){
    LuxUser luxUser = LuxUser.builder()
            .firstName("Sandra")
            .lastName("Oluwatobi")
            .email("Sandie@gmail.com")
            .phoneNumber("0709545210")
            .password("sunny12")
            .luxUserRole(LANDLORD)
            .build();

        log.info("Before saving ->{}", luxUser);
    assertThat(luxUser.getId()).isNull();
        luxUserRepository.save(luxUser);
        log.info("After saving -> {}", luxUser);
    assertThat(luxUser.getId()).isNotNull();

        LuxUser luxUser2 = LuxUser.builder()
                .firstName("Sandra")
                .lastName("Oluwatobi")
                .email("Sandie@gmail.com")
                .phoneNumber("0709545210")
                .password("sunny2")
                .luxUserRole(LANDLORD)
                .build();

        //assertThrows(DataIntegrityViolationException.class, () -> luxUserRepository.save(luxUser2));
        log.info("after saving -> {}", luxUser2);
}
    @Test
    void findByEmail() {
    }

    @Test
    void enableLuxUser() {
    }
}