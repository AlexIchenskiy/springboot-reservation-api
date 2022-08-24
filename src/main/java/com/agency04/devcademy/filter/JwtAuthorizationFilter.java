package com.agency04.devcademy.filter;

import com.agency04.devcademy.model.Users;
import com.agency04.devcademy.repository.UsersRepository;
import com.agency04.devcademy.service.impl.UsersServiceImpl;
import com.agency04.devcademy.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    @Autowired
    private JwtTokenUtil tokenUtil;

    @Autowired
    private UsersServiceImpl usersService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader("Authorization");

        if (header == null) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        if (token != null) {
            String username = tokenUtil.getUsernameFromToken(token);
            Users userDetails = usersService.findByEmail(username);
            Set<GrantedAuthority> authoritySet = userDetails.getAuthorities();

            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username,
                        userDetails.getPassword(),
                        authoritySet);
            }

            return null;
        }

        return null;
    }

}
