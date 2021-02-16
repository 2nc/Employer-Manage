package com.wu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMVC implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/main.html").setViewName("index");
        registry.addViewController("/login.html").setViewName("login");
    }


    public void addInterceptors(InterceptorRegistry registry){
        //registry.addInterceptor(new LoginHandlerInterceptor())
                //.addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
    }
}
