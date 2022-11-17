package com.deventually.devcallendar.app;

import com.deventually.devcallendar.context.RequestContextResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        LocaleResolver localeResolver = applicationContext.getBean(LocaleResolver.class);
        resolvers.add(new RequestContextResolver(localeResolver));
    }
}
