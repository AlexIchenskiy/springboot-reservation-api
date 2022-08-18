package com.agency04.devcademy.service;

import com.agency04.devcademy.model.Reservation;
import com.agency04.devcademy.model.Users;

import java.util.List;

public interface UsersService {

    Users save(Users users);
    List<Users> findAll();
    Users findById(Long id);
    Users update(Long id, Users usersDetails);
    void deleteById(Long id);

}
