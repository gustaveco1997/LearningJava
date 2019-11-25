package br.com.codenation.projetolongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("br.com.codenation.projetolongo.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Gustavo Reis", "urlContato", "gustavohdosreis@gmail.com");
        return new ApiInfo("APPLICATION_API",
                "APLICACAO CODENATION",
                "1.0.0-REALEASE",
                "Terms of service",
                contact, "License of API", "API License URL", Collections.emptyList());
    }
}
//apiOperation
//apiResponses