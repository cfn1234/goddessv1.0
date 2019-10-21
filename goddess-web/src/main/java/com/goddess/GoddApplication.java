package com.goddess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * <br>
 * 〈功能详细描述〉---spring boot启动类
 * com.goddess
 *
 * @author caofengnian 2019/3/13 0013 15:29
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@SpringBootApplication
public class GoddApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GoddApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(GoddApplication.class, args);
    }


}
