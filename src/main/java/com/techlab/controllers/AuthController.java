package com.techlab.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techlab.dto.LoginRequest;
import com.techlab.dto.UserDto;
import com.techlab.dto.UserRegister;
import com.techlab.entity.User;
import com.techlab.filter.FilterBase;
import com.techlab.mapper.IUserMapper;
import com.techlab.repository.UserRepository;
import com.techlab.service.implementation.UserService;

@RestController
@RequestMapping("api/auth")
public class AuthController
        extends BaseController<Long, User, UserDto, UserRepository, IUserMapper, UserService, FilterBase> {

    public AuthController(UserService service) {
        super(service);
    }

    @PostMapping("/register")
    public UserRegister createResource(@RequestBody UserRegister dto) {
        this.service.Registrar(dto);
        return dto;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest dto) {
        return this.service.login(dto);
    }
}
