package com.luxhomes.luxhomes.luxUser;

import com.luxhomes.luxhomes.models.LuxUser;
import com.luxhomes.luxhomes.repositories.LuxUserRepository;
import com.luxhomes.luxhomes.services.LuxUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.Optional;

import static com.luxhomes.luxhomes.models.LuxUserRole.LANDLORD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LuxUserRepositoryTest {

    @Autowired
    LuxUserRepository luxUserRepository;
    @Autowired
    LuxUserService userService;

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

        assertThrows(DataIntegrityViolationException.class, () -> luxUserRepository.save(luxUser2));
        log.info("after saving -> {}", luxUser2);
}
    @Test
    void findByEmail() {
        LuxUser luxUser = LuxUser.builder()
                .firstName("Sandra")
                .lastName("Oluwatobi")
                .email("Sandie@gmail.com")
                .phoneNumber("0709545210")
                .password("sunny12")
                .luxUserRole(LANDLORD)
                .build();

        log.info("Before saving ->{}", luxUser);
        luxUserRepository.save(luxUser);
        Optional<LuxUser> savedUser = luxUserRepository.findByEmail(luxUser.getEmail());
        assertEquals(savedUser.get().getFirstName(), luxUser.getFirstName());
    }

    @Test
    void enableLuxUser() {
        LuxUser luxUser = LuxUser.builder()
                .firstName("Sandra")
                .lastName("Oluwatobi")
                .email("Sandie@gmail.com")
                .phoneNumber("0709545210")
                .password("sunny12")
                .luxUserRole(LANDLORD)
                .build();

        log.info("Before saving ->{}", luxUser);
        userService.signUpUser(luxUser);
        assertFalse(luxUser.isEnabled());
        userService.enableLuxUser(luxUser.getEmail());
        //assertTrue(luxUser.isEnabled());
    }
}