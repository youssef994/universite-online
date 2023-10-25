package com.microservices.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only Product Management API")
                .pathsToMatch("/contrat/**")
                .pathsToExclude("**")
                .build();
    }
    @Bean
    public GroupedOpenApi All() {
        return GroupedOpenApi.builder()
                .group("ALL API")
                .pathsToMatch("/**")
                .build();
    }

}