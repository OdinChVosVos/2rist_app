package ru.astradev.tourist_app.db.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.*;

import java.util.Arrays;
import java.util.Collection;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class Users implements UserDetails {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_generator")
    @SequenceGenerator(name = "users_generator", sequenceName = "users_seq", allocationSize = 1)
    private Long id;

    private String mail;
    private String password;
    private String phone;
    private String firstname;
    private String lastname;
    private String login;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Users(String mail, String password, String phone, String firstname, String lastname, String login, Role role) {
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.firstname = firstname;
        this.lastname = lastname;
        this.login = login;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return mail;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
