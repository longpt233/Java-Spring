package com.company.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.company.spring.service.impl.UserDetailsServiceImp;
 
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
   @Autowired
   UserDetailsServiceImp userDetailsService;
 
   @Bean
   public BCryptPasswordEncoder passwordEncoder() {
      BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
      return bCryptPasswordEncoder;
   }
 
   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
      // Setting Service to find User in the database.
      // And Setting PassswordEncoder
      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
 
   }
 
   @Override
   protected void configure(HttpSecurity http) throws Exception {
 
      http.csrf().disable();
 
      // Requires login with role ROLE_EMPLOYEE or ROLE_MANAGER.
      // If not, it will redirect to /admin/login.
      http.authorizeRequests().antMatchers("/admin/**")//
            .access("hasRole('ADMIN')");
 
      http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
 
      // Configuration for Login Form.
      http.authorizeRequests().and().formLogin()//
 
            //
            .loginProcessingUrl("/j_spring_security_check") // Submit URL
            .loginPage("/login")
            .defaultSuccessUrl("/admin/product")
            .failureUrl("/admin/login?error=true")
            .usernameParameter("userName")
            .passwordParameter("password")
 
            // Configuration for the Logout page.
            // (After logout, go to home page)
            .and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/");
 
   }
}
