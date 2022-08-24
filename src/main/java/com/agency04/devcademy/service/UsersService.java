package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.model.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UsersService extends UserDetailsService {

    Users save(Users users);
    List<Users> findAll();
    Users findById(Long id);
    Users findByEmail(String email);
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    Users update(Long id, Users usersDetails);
    void deleteById(Long id);

}
