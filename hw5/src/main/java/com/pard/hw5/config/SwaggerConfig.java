package com.pard.hw5.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .addSecurityItem(securityRequirement())
                .components(components())
                .info(apiInfo());
    }

    public Components components(){
        return new Components()
                .addSecuritySchemes("jwtAuth", new SecurityScheme()
                        .name("jwtAuth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT"));
    }

    public Info apiInfo(){
        return new Info()
                .title("로그인 가능한 블로그")
                .description("로그인 가능한 유저별 CRUD 블로그")
                .version("1.0.0");
    }

    public SecurityRequirement securityRequirement(){
        return new SecurityRequirement().addList("jwtAuth");
    }


}
