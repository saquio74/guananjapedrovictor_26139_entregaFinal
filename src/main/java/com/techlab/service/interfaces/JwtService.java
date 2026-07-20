package com.techlab.service.interfaces;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    public String generate(UserDetails user);

    public String extractUsername(String token);

    public boolean isValid(String token, UserDetails user);
}
