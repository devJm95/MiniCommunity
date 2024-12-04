package com.MiniCommunity.common.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI costomOpenAPI() {
        return new OpenAPI()
                    .info(new Info()
                    .title("MiniCommunity")
                    .version("1.0.0")
                    .description("MiniCommunity API"));
    }
}
