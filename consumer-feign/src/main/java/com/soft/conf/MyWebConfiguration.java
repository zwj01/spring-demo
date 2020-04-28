package com.soft.conf;

import com.sofg.link.FeignRequestInterceptor;
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
    ShareHandle shareHandle(){
        return new ShareHandle();
    }

    @Bean
    FeignRequestInterceptor feignRequestInterceptor(){
        return new FeignRequestInterceptor();
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
