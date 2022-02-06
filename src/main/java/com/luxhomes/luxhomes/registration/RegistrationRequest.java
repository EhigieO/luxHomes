package com.luxhomes.luxhomes.registration;


import com.luxhomes.luxhomes.models.LuxUserRole;
import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String password;
    private LuxUserRole luxUserRole;
}
