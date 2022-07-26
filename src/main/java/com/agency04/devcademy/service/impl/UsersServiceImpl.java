package com.agency04.devcademy.service.impl;

import com.agency04.devcademy.exception.AuthException;
import com.agency04.devcademy.exception.UsersNotFoundException;
import com.agency04.devcademy.model.Users;
import com.agency04.devcademy.repository.UsersRepository;
import com.agency04.devcademy.service.UsersService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(@Qualifier("usersRepository") UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public Users save(Users users) {
        return usersRepository.save(users);
    }

    @Override
    public List<Users> findAll() {
        return usersRepository.findAll();
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));
    }

    @Override
    public Users findByEmail(String email) {
        return usersRepository.findByEmail(email)
                .orElseThrow(() -> new UsersNotFoundException(email));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users userDetails = usersRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        Set<GrantedAuthority> authoritySet = userDetails.getAuthorities();

        return new User(userDetails.getEmail(), userDetails.getPassword(), authoritySet);
    }

    @Override
    public Users update(Long id, Users usersDetails) {
        Users users = usersRepository.findById(id)
                .orElseThrow(() -> new UsersNotFoundException(id));

        users.setFirstName(usersDetails.getFirstName());
        users.setLastName(usersDetails.getLastName());
        users.setEmail(users.getEmail());

        return usersRepository.save(users);
    }

    @Override
    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }
}
