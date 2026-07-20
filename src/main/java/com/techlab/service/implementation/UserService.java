package com.techlab.service.implementation;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.techlab.dto.LoginRequest;
import com.techlab.dto.UserDto;
import com.techlab.dto.UserRegister;
import com.techlab.entity.User;
import com.techlab.mapper.IUserMapper;
import com.techlab.repository.UserRepository;
import com.techlab.service.interfaces.JwtService;

@Service
public class UserService extends BaseService<Long, User, UserDto, UserRepository, IUserMapper> {

    public final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService userDetailsService;
    private final JwtService jwtService;

    public UserService(UserRepository repository, IUserMapper mapper, PasswordEncoder passwordEncoder,
            AuthenticationManager manager, CustomUserDetailService userDetailService, JwtService jwtService) {
        super(repository, mapper);
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = manager;
        this.userDetailsService = userDetailService;
        this.jwtService = jwtService;
    }

    public void Registrar(UserRegister dto) {
        User user = new User(null, null, null, null, null, dto.getEmail(), null);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        repository.save(user);
    }

    public String login(LoginRequest dto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dto.email,
                dto.password));
        UserDetails user = userDetailsService
                .loadUserByUsername(dto.email);

        return jwtService.generate(user);
    }

}
