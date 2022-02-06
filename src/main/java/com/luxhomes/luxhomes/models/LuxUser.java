package com.luxhomes.luxhomes.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;


@Data
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Builder
public class LuxUser implements UserDetails{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true, nullable = false)
    @NotNull
    private String email;
    private String password;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private LuxUserRole luxUserRole;

    @Builder.Default
    private Boolean locked = false;
    @Builder.Default
    private Boolean enabled = false;

    public LuxUser(String firstName,
                   String lastName,
                   String email,
                   String phoneNumber,
                   String password,
                   LuxUserRole luxUserRole
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.luxUserRole = luxUserRole;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(luxUserRole.name());

        return Collections.singletonList(authority );
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}