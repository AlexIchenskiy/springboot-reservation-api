package com.agency04.devcademy.controller;

import com.agency04.devcademy.form.LoginForm;
import com.agency04.devcademy.service.impl.LoginServiceImpl;
import com.agency04.devcademy.util.JwtTokenUtil;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginForm loginDetails) {
        loginService.authenticate(loginDetails.getEmail(), loginDetails.getPassword());

        return new ResponseEntity<>(jwtTokenUtil.generateToken(loginDetails), HttpStatus.OK);
    }

}
