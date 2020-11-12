package com.goddess.eneity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

/**
 * @author: cfn
 * @date: 2020/11/10 11:01
 * @description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SecurityUserDetails implements UserDetails {

	private String password;

	private String username;

	private Collection<? extends GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public SecurityUserDetails(String userName, Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
		this.setUsername(userName);
		String encode = new BCryptPasswordEncoder().encode("123456");
		this.setPassword(encode);
		this.setAuthorities(authorities);
	}

	/**
	 * 账户是否过期
	 *
	 * @return
	 */
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	/**
	 * 是否禁用
	 *
	 * @return
	 */
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	/**
	 * 密码是否过期
	 *
	 * @return
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	/**
	 * 是否启用
	 *
	 * @return
	 */
	@Override
	public boolean isEnabled() {
		return true;
	}
}