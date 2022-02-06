package com.luxhomes.luxhomes.services;

import com.luxhomes.luxhomes.models.LuxUser;
import com.luxhomes.luxhomes.registration.token.ConfirmationToken;
import com.luxhomes.luxhomes.registration.token.ConfirmationTokenService;
import com.luxhomes.luxhomes.repositories.LuxUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class LuxUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final LuxUserRepository luxUserRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return luxUserRepository.findByEmail(email)
                .orElseThrow(()-> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email)));
    }

    public String signUpUser(LuxUser luxUser){
        boolean userExits = luxUserRepository.findByEmail(luxUser.getEmail())
                .isPresent();

        if(userExits){
            throw new IllegalStateException("email already taken");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(luxUser.getPassword());

        luxUser.setPassword(encodedPassword);

        luxUserRepository.save(luxUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                luxUser
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;
    }

    public void enableLuxUser(String email) {
        luxUserRepository.enableLuxUser(email);
    }
    
    public List<LuxUser> getAllUsers(){
        return luxUserRepository.findAll();
    }
}
