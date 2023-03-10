package com.example.mbook.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class swaggerConfig {
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(
                        new Info().title("'MBook(엠북)' API")
                                .description("'엠북' API 명세서입니다.")
                                .version("v1")
                );
    }
}
