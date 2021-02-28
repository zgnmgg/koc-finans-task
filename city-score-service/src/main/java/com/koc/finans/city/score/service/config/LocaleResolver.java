package com.koc.finans.city.score.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
public class LocaleResolver extends AcceptHeaderLocaleResolver implements WebMvcConfigurer {

    @Override
    public List<Locale> getSupportedLocales() {
        return Arrays.asList(
                new Locale("tr"),
                new Locale("en")
        );
    }

    @Override
    public Locale getDefaultLocale() {
        return new Locale("tr", "TR");
    }

    @Bean
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
        rs.setBasename("messages/messages");
        rs.setDefaultEncoding("UTF-8");
        return rs;
    }
}