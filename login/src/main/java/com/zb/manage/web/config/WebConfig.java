package com.zb.manage.web.config;

import com.zb.manage.web.interceptor.SignInInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    private SignInInterceptor signInInterceptor = new SignInInterceptor();

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(signInInterceptor)
                .addPathPatterns("/api/**", "/web/**")
                .excludePathPatterns("/api/user/sign_in", "/sign_in")
                .order(1040);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }

    @Bean
    public SignInInterceptor getSignInInterceptor() {
        return signInInterceptor;
    }
}
