package com.xuli.farm.webMvcConfig;

import com.xuli.farm.Interceptor.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppconfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new AdminLoginInterceptor());
        registration.addPathPatterns("/admin/**");                      //所有路径都被拦截
        registration.excludePathPatterns(                         //添加不拦截路径
                "/admin/sign_in.html",
                "/admin/reset-password.html",
                "/admin/login",
                "/admin/**/*.js",
                "/admin/**/*.css"
        );
    }
}
