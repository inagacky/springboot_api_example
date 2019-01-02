package com.inagacky.api_sample_app.configure;

import com.inagacky.api_sample_app.util.constants.ApiRoutingConstants;
import com.inagacky.api_sample_app.application.http.Interceptor.AuthorizationInterceptor;
import org.modelmapper.ModelMapper;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SampleConfigurer implements WebMvcConfigurer {

    @Bean(name="validator")
    public LocalValidatorFactoryBean localValidatorFactoryBean() {
        LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
        localValidatorFactoryBean.setValidationMessageSource(messageSource());

        return localValidatorFactoryBean;
    }

    @Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource reloadableResourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        reloadableResourceBundleMessageSource.setBasename("classpath:ValidationMessages");
        reloadableResourceBundleMessageSource.setDefaultEncoding("UTF-8");

        return reloadableResourceBundleMessageSource;
    }

    @Bean(name = "requestLoggingFilter")
    public CommonsRequestLoggingFilter requestLoggingFilter() {

        CommonsRequestLoggingFilter commonsRequestLoggingFilter = new CommonsRequestLoggingFilter();
        commonsRequestLoggingFilter.setIncludeClientInfo(true);
        commonsRequestLoggingFilter.setIncludeQueryString(true);
        commonsRequestLoggingFilter.setIncludeHeaders(true);
        commonsRequestLoggingFilter.setIncludePayload(true);

        return commonsRequestLoggingFilter;
    }

    @Bean(name = "passwordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = "modelMapper")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean(name = "authorizationInterceptor")
    public AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorizationInterceptor())
                .addPathPatterns(ApiRoutingConstants.API_BASE_PATH + "/**");
    }
}
