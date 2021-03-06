package com.soft.config;

import com.sofg.link.LinkResponseBody;
import com.sofg.link.RequestLinkInterceptor;
import com.sofg.link.ShareHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebConfiguration implements WebMvcConfigurer {

    @Bean
    public ShareHandle shareHandle(){
        return new ShareHandle();
    }

    @Bean
    public LinkResponseBody linkResponseBody(){
        return new LinkResponseBody();
    }

    @Bean
    public RequestLinkInterceptor requestLinkInterceptor(){
        return new RequestLinkInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLinkInterceptor());
    }
}
