package ru.ds.education.testspringboot.core.service;

import lombok.RequiredArgsConstructor;

import lombok.var;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.ds.education.testspringboot.api.job.AuthenticationRequest;
import ru.ds.education.testspringboot.api.job.AuthenticationResponse;
import ru.ds.education.testspringboot.api.job.JwtService;
import ru.ds.education.testspringboot.api.job.RegisterRequest;
import ru.ds.education.testspringboot.core.mapper.UsersMapper;
import ru.ds.education.testspringboot.core.model.UsersDto;
import ru.ds.education.testspringboot.db.entity.Role;
import ru.ds.education.testspringboot.db.entity.Users;
import ru.ds.education.testspringboot.db.repository.UsersRepository;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UsersRepository usersRepository;
    private final UsersMapper usersMapper;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request){
        Users user = new Users(
                request.getMail(), passwordEncoder.encode(request.getPassword()),
                request.getPhone(),
                request.getFirstname(),
                request.getLastname(), request.getLogin(), Role.USER
        );

        usersRepository.add(user.getMail(), user.getPassword(),
                user.getPhone(), user.getFirstname(), user.getLastname(),
                user.getLogin(), user.getRole().toString());

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMail(),
                        request.getPassword()
                )
        );
        Users user = usersRepository.getByMail(request.getMail());
        if (user == null){
            return null;
        }

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
