package com.example.multitenancy.schema.config;

import javax.servlet.Filter;

import com.example.multitenancy.schema.config.tenants.TenantInterceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

    private final TenantInterceptor interceptor;

    public WebMvcConfig(TenantInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        log.info("web mvc add interceptor");
        registry.addWebRequestInterceptor(interceptor);
    }

    @Bean
    public Filter shallowETagFilter() {
        return new ShallowEtagHeaderFilter();
    }

}
