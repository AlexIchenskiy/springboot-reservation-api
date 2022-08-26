package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.exception.UsersNotFoundException;
import com.agency04.devcademy.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    public void authenticate(String email, String password) {
        try {
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(email, password,
                            usersService.findByEmail(email).getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            authenticationManager.authenticate(authentication);
        } catch (AuthenticationException e) {
            throw new UsersNotFoundException();
        }
    }
}
