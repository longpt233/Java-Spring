package com.company.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.company.spring.entity.Account;
import com.company.spring.repository.AccountRepo;


@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	AccountRepo accRepo;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accRepo.findByName(username);
        System.out.println("Account= " + account);
 
        if (account == null) {
            throw new UsernameNotFoundException("User " //
                    + username + " was not found in the database");
        }
 
        // ADMIN ?
        String role = account.getUserRole();
//        System.out.println("role ====="+role);
 
        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
 
        // ADMIN
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+role);
//        System.out.println("rolAue ====="+authority.toString());
        grantList.add(authority);
 
        boolean enabled = account.isActive();
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
 
        UserDetails userDetails = (UserDetails) new User(account.getUserName(), //
                account.getEncrytedPassword(), enabled, accountNonExpired, //
                credentialsNonExpired, accountNonLocked, grantList);
 
        return userDetails;
    
	}

}
