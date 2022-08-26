package com.agency04.devcademy.config;

import com.agency04.devcademy.exception.AuthException;
import com.agency04.devcademy.filter.JwtAuthorizationFilter;
import com.agency04.devcademy.service.impl.UsersServiceImpl;
import com.agency04.devcademy.util.PasswordEncoderTEST;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsersServiceImpl usersService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/reservation").hasAuthority("ADMIN")
                .antMatchers("/reservation/**").hasAuthority("ADMIN")
                .antMatchers("/api/**").hasAuthority("USER")
                .antMatchers("/api").hasAuthority("USER")
                .antMatchers("/swagger-ui.html").hasAuthority("ADMIN")
                .antMatchers("/swagger-ui.html/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(new AuthException())
                .and()
                .csrf().disable()
                .formLogin().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usersService).passwordEncoder(passwordEncoderTEST());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoderTEST passwordEncoderTEST() {
        return new PasswordEncoderTEST();
    }

    /*@Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

}
