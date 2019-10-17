package com.goddess.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *shiro配置类
 * com.goddess.config
 * @author caofengnian
 * @Date 2019/7/19 0019
 *
 */
@Configuration
public class ShiroConfig {
	private static final Logger logger = LoggerFactory.getLogger(ShiroConfig.class);

	/**
	 * 注入自定义的 Realm
	 *
	 * @return MyRealm
	 */
	@Bean
	public UserRealm myAuthRealm() {
		UserRealm myRealm = new UserRealm();
		logger.info("====UserRealm注册完成=====");
		return myRealm;
	}

	/**
	 * 注入安全管理器
	 *
	 * @return SecurityManager
	 */
	@Bean
	public SecurityManager securityManager() {
		// 将自定义 Realm 加进来
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager(myAuthRealm());
		logger.info("====securityManager注册完成====");
		return securityManager;
	}

	/**
	 * 注入 Shiro 过滤器
	 *
	 * @param securityManager 安全管理器
	 * @return ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		// 定义 shiroFactoryBean
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

		// 设置自定义的 securityManager
		shiroFilterFactoryBean.setSecurityManager(securityManager);

		// 设置默认登录的 URL，身份认证失败会访问该 URL
		shiroFilterFactoryBean.setLoginUrl("/login");
		// 设置成功之后要跳转的链接
		shiroFilterFactoryBean.setSuccessUrl("/success");
		// 设置未授权界面，权限认证失败会访问该 URL
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

		// LinkedHashMap 是有序的，进行顺序拦截器配置
		Map<String, String> filterChainMap = new LinkedHashMap<>();

		// 配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等，anon 表示放行
		filterChainMap.put("/css/**", "anon");
		filterChainMap.put("/imgs/**", "anon");
		filterChainMap.put("/js/**", "anon");
		filterChainMap.put("/swagger-*/**", "anon");
		filterChainMap.put("/swagger-ui.html/**", "anon");
		// 登录 URL 放行
		filterChainMap.put("/login", "anon");

		// 以“/user/admin” 开头的用户需要身份认证，authc 表示要进行身份认证
		filterChainMap.put("/user/admin*", "authc");
		// “/user/student” 开头的用户需要角色认证，是“admin”才允许
		filterChainMap.put("/user/student*/**", "roles[admin]");
		// “/user/teacher” 开头的用户需要权限认证，是“user:create”才允许
		filterChainMap.put("/user/teacher*/**", "perms[\"user:create\"]");

		// 配置 logout 过滤器
		filterChainMap.put("/logout", "logout");

		// 设置 shiroFilterFactoryBean 的 FilterChainDefinitionMap
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
		logger.info("====shiroFilterFactoryBean注册完成====");
		return shiroFilterFactoryBean;
	}

}
