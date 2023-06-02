package com.store.java.demo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger {
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("Springapiteste-public")
                .pathsToMatch("/customers")
                .build();
    }
}