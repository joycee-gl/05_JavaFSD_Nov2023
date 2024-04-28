package com.greatlearning.ssrs.security.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;    

import com.greatlearning.ssrs.security.service.impl.SsrsUserDetailsServiceImpl;

@Configuration
public class SsrsSecurityConfiguration {

  @Bean
  public UserDetailsService userDetailsService() {
    return new SsrsUserDetailsServiceImpl();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider ssrsDaoAuthenticationProvider() {

    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userDetailsService());
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }
  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .requestMatchers("/","/students/list", "/students/displayStudentForm", "/students/save").hasAnyAuthority("NORMAL_USER","ADMIN_USER")
      .requestMatchers("/students/displayStudentForm_Update","/students/delete").hasAuthority("ADMIN_USER")
      .anyRequest().authenticated()
      .and()
      .formLogin().loginProcessingUrl("/login").successForwardUrl("/students/list").permitAll()
      .and()
      .logout().logoutSuccessUrl("/login").permitAll()
      .and()
      .exceptionHandling().accessDeniedPage("/students/403")
      .and()
      .cors().and().csrf().disable();
    
    http.authenticationProvider(ssrsDaoAuthenticationProvider());
    return http.build();
  }    
}  