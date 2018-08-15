package com.cy.test.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @version 1.0
 * @description：将拦截器注入到容器当中
 * @author: Yang.Chang
 * @project: SpringJwtSecurity
 * @package: com.cy.test.interceptor
 * @email: cy880708@163.com
 * @date: 2018/8/15 下午6:36
 * @mofified By:
 */
@Configuration
public class CustomWebAppConfigurer extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(new CustomizeInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
