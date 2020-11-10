package com.goddess.config.jwt;

import com.goddess.eneity.SecurityUserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: cfn
 * @date: 2020/11/10 11:00
 * @description:
 */
@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
		System.out.println("JwtUserDetailsService:" + user);
		List<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new SecurityUserDetails(user,authorityList);
	}

}
