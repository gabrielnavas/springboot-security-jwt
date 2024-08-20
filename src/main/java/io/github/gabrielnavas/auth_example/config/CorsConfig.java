package io.github.gabrielnavas.auth_example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {

    @Value("${application.cors.urls}")
    private String[] allowedOrigins;

    @Value("${application.cors.allowed-methods}")
    private String[] allowedMethods;

    @Value("${application.cors.allowed-headers}")
    private String[] allowedHeaders;

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOrigins(Arrays.stream(allowedOrigins).toList());
        config.setAllowedHeaders(Arrays.stream(allowedHeaders).toList());
        config.setAllowedMethods(Arrays.stream(allowedMethods).toList());
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
