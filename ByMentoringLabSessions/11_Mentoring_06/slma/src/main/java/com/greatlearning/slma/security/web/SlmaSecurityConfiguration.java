package com.greatlearning.slma.security.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.greatlearning.slma.security.service.impl.SlmaUserDetailsServiceImpl;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;    

@Configuration
public class SlmaSecurityConfiguration {

  @Bean
  public UserDetailsService userDetailsService() {
    return new SlmaUserDetailsServiceImpl();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider slmaDaoAuthenticationProvider() {

    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .requestMatchers("/","/books/list", "/books/search", "/books/displayBookForm", "/books/save").hasAnyAuthority("NORMAL_USER","ADMIN_USER")
      .requestMatchers("/books/displayBookForm_Update","/books/delete").hasAuthority("ADMIN_USER")
      .anyRequest().authenticated()
      .and()
      .formLogin().loginProcessingUrl("/login").successForwardUrl("/books/list").permitAll()
      .and()
      .exceptionHandling().accessDeniedPage("/books/403")
      .and()
      .cors().and().csrf().disable();
    
    http.authenticationProvider(slmaDaoAuthenticationProvider());
    return http.build();
  }   
}  