package com.goddess.config.jwt;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: cfn
 * @date: 2020/11/10 11:09
 * @description: 没有凭证拦截返回
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
	@Override
	public void commence(HttpServletRequest request,
						 HttpServletResponse response,
						 AuthenticationException authException)
			throws IOException, ServletException {

		System.out.println("JwtAuthenticationEntryPoint:"+authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"没有凭证");
	}
}
